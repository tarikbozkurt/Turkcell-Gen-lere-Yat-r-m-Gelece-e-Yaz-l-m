package com.example.rentacar.repository;

import com.example.rentacar.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental,Long> {

}
