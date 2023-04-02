package com.example.rentacar.repository;

import com.example.rentacar.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ModelRepository extends JpaRepository<Model,Long> {
    boolean existsByNameIgnoreCase(String name);
}
