package com.example.rentacar.business.rules;


import com.example.rentacar.common.constants.Messages;
import com.example.rentacar.core.exceptions.BusinessException;
import com.example.rentacar.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarBusinessRules {
    private final CarRepository repository;


    private void checkIfCarExists(long id){
        if(!repository.existsById(id))
            throw new BusinessException(Messages.Car.CAR_NOT_FOUND);

    }

    public void checkIfExistsByPlate(String plate){
        if(!repository.existsByPlate(plate)){
            throw new BusinessException(Messages.Car.PLATE_ALREADY_EXISTS);

        }
    }
}
