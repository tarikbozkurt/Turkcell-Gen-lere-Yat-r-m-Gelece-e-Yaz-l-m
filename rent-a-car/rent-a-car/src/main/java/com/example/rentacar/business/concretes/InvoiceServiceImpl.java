package com.example.rentacar.business.concretes;

import com.example.rentacar.business.abstracts.InvoiceService;
import com.example.rentacar.business.dto.requests.create.invoice.CreateInvoiceRequest;
import com.example.rentacar.business.dto.requests.update.invoice.UpdateInvoiceRequest;
import com.example.rentacar.business.dto.responses.create.invoice.CreateInvoiceResponse;
import com.example.rentacar.business.dto.responses.get.invoice.GetAllInvoicesResponse;
import com.example.rentacar.business.dto.responses.get.invoice.GetInvoiceResponse;
import com.example.rentacar.business.dto.responses.update.invoice.UpdateInvoiceResponse;
import com.example.rentacar.entity.Invoice;
import com.example.rentacar.repository.InvoiceRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository repository;
    private final ModelMapper mapper;


    @Override
    public List<GetAllInvoicesResponse> getAll() {
        List<Invoice> invoices = repository.findAll();
        List<GetAllInvoicesResponse> response = invoices
                .stream()
                .map(invoice ->
                    mapper.map(invoice,GetAllInvoicesResponse.class)
                ).toList();


        return response;
    }

    @Override
    public GetInvoiceResponse getById(long id) {
        checkIfInvoiceExists(id);
        Invoice invoice = repository.findById(id).orElseThrow();

        GetInvoiceResponse response = mapper.map(invoice,GetInvoiceResponse.class);
        return response;
    }

    @Override
    public CreateInvoiceResponse add(CreateInvoiceRequest request) {
        Invoice invoice = mapper.map(request,Invoice.class);

        invoice.setId(0);
        invoice.setTotalPrice(getTotalPrice(invoice));
        repository.save(invoice);

        CreateInvoiceResponse response = mapper.map(invoice,CreateInvoiceResponse.class);


        return response;
    }

    @Override
    public UpdateInvoiceResponse update(long id, UpdateInvoiceRequest request) {
        checkIfInvoiceExists(id);
        Invoice invoice = mapper.map(request,Invoice.class);
        invoice.setId(id);
        invoice.setTotalPrice(getTotalPrice(invoice));
        repository.save(invoice);
        UpdateInvoiceResponse response = mapper.map(invoice,UpdateInvoiceResponse.class);

        return response;
    }

    @Override
    public void delete(long id) {
        checkIfInvoiceExists(id);
        repository.deleteById(id);
    }

 //Business Rules

    private void checkIfInvoiceExists(long id){
        if(!repository.existsById(id)) {
            throw new IllegalArgumentException("hata");
        }
    }
    private double getTotalPrice(Invoice invoice){
        return invoice.getDailyPrice() * invoice.getRentedForDays();
    }

}
