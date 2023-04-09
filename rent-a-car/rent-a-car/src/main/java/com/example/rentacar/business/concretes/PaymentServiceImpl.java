package com.example.rentacar.business.concretes;

import com.example.rentacar.business.abstracts.PosService;
import com.example.rentacar.business.abstracts.PaymentService;
import com.example.rentacar.business.dto.requests.create.payment.CreatePaymentRequest;
import com.example.rentacar.business.dto.requests.update.payment.UpdatePaymentRequest;
import com.example.rentacar.business.dto.responses.create.payment.CreatePaymentResponse;
import com.example.rentacar.business.dto.responses.get.payment.GetAllPaymentResponse;
import com.example.rentacar.business.dto.responses.get.payment.GetPaymentResponse;
import com.example.rentacar.business.dto.responses.update.payment.UpdatePaymentResponse;
import com.example.rentacar.core.dto.CreateRentalPaymentRequest;
import com.example.rentacar.entity.Payment;
import com.example.rentacar.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository repository;
    private final ModelMapper mapper;

    private final PosService posService;
    @Override
    public List<GetAllPaymentResponse> getAll() {

        List<Payment> payments = repository.findAll();

        List<GetAllPaymentResponse> response = payments
                .stream()
                .map(payment -> mapper.map(payment, GetAllPaymentResponse.class)).toList();


        return response;
    }

    @Override
    public GetPaymentResponse getById(long id) {
        checkIfPaymentExists(id);
        Payment payment = repository.findById(id).orElseThrow();

        GetPaymentResponse response = mapper.map(payment,GetPaymentResponse.class);
        return response;
    }

    @Override
    public CreatePaymentResponse add(CreatePaymentRequest request) {
        checkIfCardExists(request);
        Payment payment = mapper.map(request, Payment.class);
        payment.setId(0);
        repository.save(payment);
        CreatePaymentResponse response = mapper.map(payment, CreatePaymentResponse.class);

        return response;
    }

    @Override
    public UpdatePaymentResponse update(long id, UpdatePaymentRequest request) {
        checkIfPaymentExists(id);
        Payment payment = mapper.map(request, Payment.class);
        payment.setId(id);
        repository.save(payment);
        UpdatePaymentResponse response = mapper.map(payment, UpdatePaymentResponse.class);

        return response;
    }

    @Override
    public void delete(long id) {
        checkIfPaymentExists(id);
        repository.deleteById(id);
    }

    @Override
    public void processRentalPayment(CreateRentalPaymentRequest request) {

        checkIfPaymentValid(request);

        //cardNumarası, rental tarafından ulaşabileceğimiz uniq kısmı..
        Payment payment = repository.findByCardNumber(request.getCardNumber());

        //rental dan cardNumber geldi
        //gelen card numarasının balancı ile price kontrol ediliyor.
        checkIfBalanceIsEnought(request.getPrice(),payment.getBalance());

        //adaptor btkademide örneği var
        // fake pos service homework !!
        posService.pay();

        payment.setBalance(payment.getBalance() - request.getPrice());

        //card numarasına göre aldık id zaten var üzerine kaydedecek
        repository.save(payment);
    }

    private void checkIfPaymentValid(CreateRentalPaymentRequest request){
        if(!repository.existsByCardNumberAndCardHolderAndCardExpirationYearAndCardExpirationMonthAndCardCvv(
                request.getCardNumber(),
                request.getCardHolder(),
                request.getCardExpirationYear(),
                request.getCardExpirationMonth(),
                request.getCardCvv()
        )){
            throw new RuntimeException("Kart bilgileriniz hatalı.");
        }
    }
    private void checkIfPaymentExists(long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Ödeme bilgisi bulunamadı.");
        }
    }
    private void checkIfCardExists(CreatePaymentRequest request){
        if(repository.existsByCardNumber(request.getCardNumber())){
            throw new RuntimeException("Kart numarası zaten var !");
        }

    }
    //balancı kontrol edeceğiz.
    private void checkIfBalanceIsEnought(double price,double balance){
        if(balance < price)
            throw new RuntimeException("Yetersiz bakiye!");
    }
    private void checkIfPaymentIsValid(CreateRentalPaymentRequest request) {
        if (!repository.existsByCardNumberAndCardHolderAndCardExpirationYearAndCardExpirationMonthAndCardCvv(
                request.getCardNumber(),
                request.getCardHolder(),
                request.getCardExpirationYear(),
                request.getCardExpirationMonth(),
                request.getCardCvv()
        )) {
            throw new RuntimeException("Kart bilgileriniz hatalı.");
        }
    }

}
