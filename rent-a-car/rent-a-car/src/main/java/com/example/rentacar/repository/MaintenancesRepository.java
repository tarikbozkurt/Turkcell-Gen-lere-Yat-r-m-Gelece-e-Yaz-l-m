package com.example.rentacar.repository;

import com.example.rentacar.entity.Car;
import com.example.rentacar.entity.Maintenances;
import com.example.rentacar.entity.enumerations.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaintenancesRepository extends JpaRepository<Maintenances,Long> {

    Maintenances findByCarIdAndIsCompletedIsFalse(long carId);
    boolean existsByCarIdAndIsCompletedIsFalse(long carId);

}
