package com.example.rentacar.business.rules;


import com.example.rentacar.common.constants.Messages;
import com.example.rentacar.core.exceptions.BusinessException;
import com.example.rentacar.entity.enumerations.State;
import com.example.rentacar.repository.MaintenancesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MaintenanceBusinessRules {

    private final MaintenancesRepository repository;

    public void checkIfMaintenanceExists(long id) {
        if (!repository.existsById(id)) {
            throw new BusinessException(Messages.Maintenance.MAINTENANCE_NOT_FOUND);
        }
    }

    public void checkIfCarIsNotUnderMaintenance(int carId) {
        if (!repository.existsByCarIdAndIsCompletedIsFalse(carId)) {
            throw new BusinessException(Messages.Maintenance.CAR_NOT_REGISTERED_FOR_MAINTENANCE);
        }
    }

    public void checkIfCarUnderMaintenance(int carId) {
        if (repository.existsByCarIdAndIsCompletedIsFalse(carId)) {
            throw new BusinessException(Messages.Maintenance.CAR_IS_CURRENTLY_UNDER_MAINTENANCE);
        }
    }

    public void checkCarAvailabilityForMaintenance(State state) {
        if (state.equals(State.RENTED)) {
            throw new BusinessException(Messages.Maintenance.CAR_IS_CURRENTLY_RENTED_AND_CANNOT_BE_SERVICED_FOR_MAINTENANCE);
        }
    }
}
