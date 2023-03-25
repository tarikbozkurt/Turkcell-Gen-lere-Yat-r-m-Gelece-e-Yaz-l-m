package com.example.rentacar.repository;


import com.example.rentacar.entites.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//CRUD Operations
//Repositry anotasyonunu eklemek zorunda degiliz.
public interface BrandRepository extends JpaRepository<Brand,Integer> {
    //Custom queries



}
