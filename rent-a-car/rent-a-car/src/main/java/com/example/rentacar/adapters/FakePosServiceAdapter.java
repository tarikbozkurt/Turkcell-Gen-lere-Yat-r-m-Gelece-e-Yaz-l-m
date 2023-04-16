package com.example.rentacar.adapters;

import com.example.rentacar.business.abstracts.PosService;
import com.example.rentacar.common.constants.Messages;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class FakePosServiceAdapter implements PosService {


    @Override
    public void pay() {
        boolean isPaymentSuccessful = new Random().nextBoolean();
        if (!isPaymentSuccessful) throw new RuntimeException(Messages.Payment.PAYMENT_FAILED);
    }

}
