package com.example.rentacar.business.dto.responses.get.payment;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetPaymentResponse {

    private long id;
    private String cardNumber;
    private String cardHolder;
    private int cardExpirationYear;
    private int cardExpirationMonth;
    //Matematiksel bir işlem olmayacağı için string aldık CVV yi.
    private String cardCvv;
    private double balance;
}
