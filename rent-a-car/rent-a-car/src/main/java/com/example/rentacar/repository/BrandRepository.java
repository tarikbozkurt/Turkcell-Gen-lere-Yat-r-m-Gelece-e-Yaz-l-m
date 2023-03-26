package com.example.rentacar.repository;


import com.example.rentacar.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

//CRUD Operations
//Repositry anotasyonunu eklemek zorunda degiliz.
public interface BrandRepository extends JpaRepository<Brand,Long> {
    //Custom queries



}
