package com.example.rentacar.business.rules;


import com.example.rentacar.business.dto.requests.create.payment.CreatePaymentRequest;
import com.example.rentacar.common.constants.Messages;
import com.example.rentacar.common.dto.CreateRentalPaymentRequest;
import com.example.rentacar.core.exceptions.BusinessException;
import com.example.rentacar.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentBusinessRules {

    private final PaymentRepository repository;

    public void checkIfPaymentExists(long id) {
        if (!repository.existsById(id)) {
            throw new BusinessException(Messages.Payment.PAYMENT_NOT_FOUND);
        }
    }

    public void checkIfBalanceIsEnough(double price, double balance) {
        if (balance < price) {
            throw new BusinessException(Messages.Payment.CARD_HAS_NOT_ENOUGHT_MONEY);
        }
    }

    public void checkIfCardExists(CreatePaymentRequest request) {
        if (repository.existsByCardNumber(request.getCardNumber())) {
            throw new BusinessException(Messages.Payment.CARD_NUMBER_ALREADY_EXISTS);
        }
    }

    public void checkIfPaymentIsValid(CreateRentalPaymentRequest request) {
        if (!repository.existsByCardNumberAndCardHolderAndCardExpirationYearAndCardExpirationMonthAndCardCvv(
                request.getCardNumber(),
                request.getCardHolder(),
                request.getCardExpirationYear(),
                request.getCardExpirationMonth(),
                request.getCardCvv()
        )) {
            throw new BusinessException(Messages.Payment.NOT_A_VALID_PAYMENT);
        }
    }
}
