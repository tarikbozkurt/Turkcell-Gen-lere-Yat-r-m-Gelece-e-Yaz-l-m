package com.example.rentacar.business.abstracts;

import com.example.rentacar.business.dto.requests.create.payment.CreatePaymentRequest;
import com.example.rentacar.business.dto.requests.update.payment.UpdatePaymentRequest;
import com.example.rentacar.business.dto.responses.create.payment.CreatePaymentResponse;
import com.example.rentacar.business.dto.responses.get.payment.GetAllPaymentResponse;
import com.example.rentacar.business.dto.responses.get.payment.GetPaymentResponse;
import com.example.rentacar.business.dto.responses.update.payment.UpdatePaymentResponse;
import com.example.rentacar.common.dto.CreateRentalPaymentRequest;


import java.util.List;

public interface PaymentService {

    List<GetAllPaymentResponse> getAll();
    GetPaymentResponse getById(long id);
    CreatePaymentResponse add(CreatePaymentRequest request);
    UpdatePaymentResponse update(long id, UpdatePaymentRequest request);
    void delete(long id);

    //burada kulanılacak dto nun hem payment tarafından, hemde rental tarafından kullanılmasını istiyoruz.
    //bu sebeple core diye bir klasör ortak alanı oluşturduk

    void processRentalPayment(CreateRentalPaymentRequest request);

}
