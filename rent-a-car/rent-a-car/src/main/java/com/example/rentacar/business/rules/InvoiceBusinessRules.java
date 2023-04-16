package com.example.rentacar.business.rules;


import com.example.rentacar.common.constants.Messages;
import com.example.rentacar.core.exceptions.BusinessException;
import com.example.rentacar.repository.InvoiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InvoiceBusinessRules {
    private final InvoiceRepository repository;

    public void checkIfInvoiceExists(long id) {
        if (!repository.existsById(id)) {
            throw new BusinessException(Messages.Invoice.INVOICE_NOT_FOUND);
        }

    }

}
