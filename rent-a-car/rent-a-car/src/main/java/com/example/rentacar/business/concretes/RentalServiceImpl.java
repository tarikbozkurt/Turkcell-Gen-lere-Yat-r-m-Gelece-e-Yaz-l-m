package com.example.rentacar.business.concretes;

import com.example.rentacar.business.abstracts.CarService;
import com.example.rentacar.business.abstracts.InvoiceService;
import com.example.rentacar.business.abstracts.PaymentService;
import com.example.rentacar.business.abstracts.RentalService;
import com.example.rentacar.business.dto.requests.create.invoice.CreateInvoiceRequest;
import com.example.rentacar.business.dto.requests.create.rental.CreateRentalRequest;
import com.example.rentacar.business.dto.requests.update.rental.UpdateRentalRequest;
import com.example.rentacar.business.dto.responses.create.invoice.CreateInvoiceResponse;
import com.example.rentacar.business.dto.responses.create.rental.CreateRentalResponse;
import com.example.rentacar.business.dto.responses.get.car.GetCarResponse;
import com.example.rentacar.business.dto.responses.get.rental.GetAllRentalResponse;
import com.example.rentacar.business.dto.responses.get.rental.GetRentalResponse;
import com.example.rentacar.business.dto.responses.update.rental.UpdateRentalResponse;
import com.example.rentacar.common.dto.CreateRentalPaymentRequest;
import com.example.rentacar.entity.Rental;
import com.example.rentacar.entity.enumerations.State;
import com.example.rentacar.repository.RentalRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@AllArgsConstructor
@Service
public class RentalServiceImpl implements RentalService {

    private final RentalRepository repository;
    private final ModelMapper mapper;
    private final CarService carService;
    private final PaymentService paymentService;

    private final InvoiceService invoiceService;


    @Override
    public List<GetAllRentalResponse> getAll() {

        List<Rental> rentals = repository.findAll();

        List<GetAllRentalResponse> response = rentals
                .stream()
                .map(rental -> mapper.map(rental,GetAllRentalResponse.class)).toList();


        return response;
    }

    @Override
    public GetRentalResponse getById(long id) {

        checkIfRentalExists(id);
        Rental rental = repository.findById(id).orElseThrow();

        GetRentalResponse response = mapper.map(rental,GetRentalResponse.class);
        return response;
    }

    @Override
    public CreateRentalResponse add(CreateRentalRequest request) {
        checkIfCarAvailable(request.getCarId());
        Rental rental = mapper.map(request,Rental.class);
        rental.setId(0);
        rental.setTotalPrice(getTotalPrice(rental));
        rental.setStartDate(LocalDateTime.now());


        CreateRentalPaymentRequest paymentRequest = new CreateRentalPaymentRequest();
        mapper.map(request.getPaymentRequest(),paymentRequest);
        paymentRequest.setPrice(getTotalPrice(rental));
        paymentService.processRentalPayment(paymentRequest);

        repository.save(rental);
        carService.changeState(request.getCarId(), State.RENTED);
        CreateRentalResponse response = mapper.map(rental,CreateRentalResponse.class);


        CreateInvoiceRequest invoiceRequest = new CreateInvoiceRequest();
        createInvoiceRequest(request,invoiceRequest,rental);
        invoiceService.add(invoiceRequest);

        //arac kiralanacagi icin aracın statusunu degistirecegiz

        return response;
    }

    @Override
    public UpdateRentalResponse update(long id, UpdateRentalRequest request) {
        checkIfRentalExists(id);
        Rental rental = mapper.map(request,Rental.class);
        rental.setId(id);
        rental.setTotalPrice(getTotalPrice(rental));
        repository.save(rental);

        UpdateRentalResponse response = mapper.map(rental,UpdateRentalResponse.class);

        return response;
    }

    @Override
    public void deleteById(long id) {
        checkIfRentalExists(id);
        long carId = repository.findById(id).get().getCar().getId();
        carService.changeState(carId, State.AVAILABLE);
        repository.deleteById(id);
    }

    //nesne varsa statik olmaz, çünki program basladığında işlem öncesinde oluşturulacak.
    //bir nesne bekliyor olması statik olamamasına sebep olur.
    // int ... gibi bir ifade olabilirdi
    /*

    getTotalPrice(double dailyPrice, int rentedForDays)
    bu şekilde nesne olmadan statik bir ifade kullanılabilir di.


 private statik double getTotalPrice(double dailyPrice, int rentedForDays){
        return dailyPrice * rentedForDays;
    }
    *
    * */
    private double getTotalPrice(Rental rental){
        return rental.getDailyPrice()* rental.getRentedForDays();
    }

    private void checkIfRentalExists(long id){
        if(!repository.existsById(id))
        {
            throw new RuntimeException("Kiralama bilgisine ulaşılamadı");

        }
    }
    private void checkIfCarAvailable(long carId){
        if(!carService.getById(carId).getState().equals(State.AVAILABLE))
            throw new RuntimeException("Araç müsait değil");
    }

    private void createInvoiceRequest(CreateRentalRequest request
    , CreateInvoiceRequest invoiceRequest,Rental rental){

        GetCarResponse car = carService.getById(request.getCarId());

        invoiceRequest.setRentedAt(rental.getStartDate());
        invoiceRequest.setModelName(car.getModelName());
        invoiceRequest.setBrandName(car.getModelBrandName());
        invoiceRequest.setDailyPrice(request.getDailyPrice());
        invoiceRequest.setPlate(car.getPlate());
        invoiceRequest.setCardHolder(request.getPaymentRequest().getCardHolder());
        invoiceRequest.setModelYear(car.getModelYear());
        invoiceRequest.setRentedForDays(request.getRentedForDays());
    }
}
