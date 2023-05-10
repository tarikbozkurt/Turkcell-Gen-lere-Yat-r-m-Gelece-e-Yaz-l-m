package com.turkcellGyGy.inventoryservice.repository;

import com.turkcellGyGy.inventoryservice.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ModelRepository extends JpaRepository<Model, UUID> {
}
