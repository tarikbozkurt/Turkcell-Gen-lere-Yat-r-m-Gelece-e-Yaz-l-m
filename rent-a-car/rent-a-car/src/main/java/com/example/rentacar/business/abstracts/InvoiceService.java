package com.example.rentacar.business.abstracts;


import com.example.rentacar.business.dto.requests.create.invoice.CreateInvoiceRequest;
import com.example.rentacar.business.dto.requests.update.invoice.UpdateInvoiceRequest;
import com.example.rentacar.business.dto.responses.create.invoice.CreateInvoiceResponse;
import com.example.rentacar.business.dto.responses.get.invoice.GetAllInvoicesResponse;
import com.example.rentacar.business.dto.responses.get.invoice.GetInvoiceResponse;
import com.example.rentacar.business.dto.responses.update.invoice.UpdateInvoiceResponse;

import java.util.List;

public interface InvoiceService {

    List<GetAllInvoicesResponse> getAll();
    GetInvoiceResponse getById(long id);
    CreateInvoiceResponse add(CreateInvoiceRequest request);
    UpdateInvoiceResponse update(long id, UpdateInvoiceRequest request);
    void delete(long id);

}
