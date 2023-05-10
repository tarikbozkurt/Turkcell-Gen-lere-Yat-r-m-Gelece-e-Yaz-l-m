package com.turkcellGyGy.inventoryservice.repository;

import com.turkcellGyGy.inventoryservice.business.dto.requests.create.CreateBrandRequest;
import com.turkcellGyGy.inventoryservice.business.dto.requests.update.UpdateBrandRequest;
import com.turkcellGyGy.inventoryservice.business.dto.responses.create.CreateBrandResponse;
import com.turkcellGyGy.inventoryservice.business.dto.responses.get.GetAllBrandsResponse;
import com.turkcellGyGy.inventoryservice.business.dto.responses.update.UpdateBrandResponse;
import com.turkcellGyGy.inventoryservice.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BrandRepository extends JpaRepository<Brand, UUID> {


}
