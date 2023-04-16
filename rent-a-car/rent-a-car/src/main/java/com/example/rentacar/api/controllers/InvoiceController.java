package com.example.rentacar.api.controllers;

import com.example.rentacar.business.abstracts.InvoiceService;
import com.example.rentacar.business.dto.requests.create.invoice.CreateInvoiceRequest;
import com.example.rentacar.business.dto.requests.update.invoice.UpdateInvoiceRequest;
import com.example.rentacar.business.dto.responses.create.invoice.CreateInvoiceResponse;
import com.example.rentacar.business.dto.responses.get.invoice.GetAllInvoicesResponse;
import com.example.rentacar.business.dto.responses.get.invoice.GetInvoiceResponse;
import com.example.rentacar.business.dto.responses.update.invoice.UpdateInvoiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api/invoices")
public class InvoiceController {

    private final InvoiceService service;

    @GetMapping
    public List<GetAllInvoicesResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetInvoiceResponse getById(@PathVariable long id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateInvoiceResponse add(@RequestBody CreateInvoiceRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateInvoiceResponse update(@PathVariable long id, @RequestBody UpdateInvoiceRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        service.delete(id);
    }
}
