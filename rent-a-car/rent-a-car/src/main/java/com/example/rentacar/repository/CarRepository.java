package com.example.rentacar.repository;

import com.example.rentacar.entity.Car;
import com.example.rentacar.entity.enumerations.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Long> {


    List<Car> findAllByStateIsNot(State state);


}
