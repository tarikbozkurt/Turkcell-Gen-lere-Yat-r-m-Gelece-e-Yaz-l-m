package com.turkcellGyGy.inventoryservice.repository;

import com.turkcellGyGy.inventoryservice.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CarRepository extends JpaRepository<Car, UUID> {

    boolean existsByPlate(String plate);
}
