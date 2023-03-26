package com.example.rentacar.business.abstracts;

import com.example.rentacar.business.dto.requests.create.brand.CreateBrandRequest;
import com.example.rentacar.business.dto.requests.update.brand.UpdateBrandRequest;
import com.example.rentacar.business.dto.requests.update.car.UpdateCarRequest;
import com.example.rentacar.business.dto.responses.create.brand.CreateBrandResponse;
import com.example.rentacar.business.dto.responses.get.brand.GetAllBrandsResponse;
import com.example.rentacar.business.dto.responses.get.brand.GetBrandResponse;
import com.example.rentacar.business.dto.responses.update.brand.UpdateBrandResponse;
import com.example.rentacar.business.dto.responses.update.car.UpdateCarResponse;
import com.example.rentacar.entity.Brand;

import java.util.List;

public interface BrandService {
//CRUD operations

  List<GetAllBrandsResponse> getAll();
  GetBrandResponse getById(long id);
  CreateBrandResponse add(CreateBrandRequest request);

  UpdateBrandResponse update(long id, UpdateBrandRequest request);
  void delete(long id);



  }
