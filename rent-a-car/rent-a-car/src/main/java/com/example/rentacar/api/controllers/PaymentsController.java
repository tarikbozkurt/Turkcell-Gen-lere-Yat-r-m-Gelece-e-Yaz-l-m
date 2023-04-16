package com.example.rentacar.api.controllers;


import com.example.rentacar.business.abstracts.PaymentService;
import com.example.rentacar.business.dto.requests.create.payment.CreatePaymentRequest;
import com.example.rentacar.business.dto.requests.update.payment.UpdatePaymentRequest;
import com.example.rentacar.business.dto.responses.create.payment.CreatePaymentResponse;
import com.example.rentacar.business.dto.responses.get.payment.GetAllPaymentResponse;
import com.example.rentacar.business.dto.responses.get.payment.GetPaymentResponse;
import com.example.rentacar.business.dto.responses.update.payment.UpdatePaymentResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/payments")
public class PaymentsController {

    private final PaymentService service;


    @GetMapping
    public List<GetAllPaymentResponse> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetPaymentResponse getById(@PathVariable long id){
        return service.getById(id);
    }

    //Belli validasyonları kontrol edeceğiz.
    @PostMapping
    public CreatePaymentResponse add(@Valid @RequestBody CreatePaymentRequest request){
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdatePaymentResponse update(@PathVariable long id, @RequestBody UpdatePaymentRequest request){
        return service.update(id,request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        service.delete(id);
    }


}
