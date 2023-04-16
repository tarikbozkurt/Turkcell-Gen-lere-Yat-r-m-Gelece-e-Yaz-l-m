package com.example.rentacar.business.rules;

import com.example.rentacar.common.constants.Messages;
import com.example.rentacar.core.exceptions.BusinessException;
import com.example.rentacar.repository.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class ModelBusinessRules {

    private final ModelRepository repository;

    public void checkIfModelExistsById(long id) {
        if (!repository.existsById(id)) {
            throw new BusinessException(Messages.Model.MODEL_NOT_FOUND);
        }
    }

    public void checkIfModelExistsByName(String name) {
        if (repository.existsByNameIgnoreCase(name)) {
            throw new BusinessException(Messages.Model.MODEL_ALREADY_EXISTS);
        }
    }
}
