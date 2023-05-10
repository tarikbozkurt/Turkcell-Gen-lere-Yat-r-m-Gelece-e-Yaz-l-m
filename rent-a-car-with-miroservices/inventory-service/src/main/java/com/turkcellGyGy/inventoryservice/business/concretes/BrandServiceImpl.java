package com.turkcellGyGy.inventoryservice.business.concretes;

import com.turkcellGyGy.commonpackage.utils.mappers.ModelMapperService;
import com.turkcellGyGy.inventoryservice.business.abstracts.BrandService;
import com.turkcellGyGy.inventoryservice.business.abstracts.CarService;
import com.turkcellGyGy.inventoryservice.business.dto.requests.create.CreateBrandRequest;
import com.turkcellGyGy.inventoryservice.business.dto.requests.create.CreateCarRequest;
import com.turkcellGyGy.inventoryservice.business.dto.requests.update.UpdateBrandRequest;
import com.turkcellGyGy.inventoryservice.business.dto.requests.update.UpdateCarRequest;
import com.turkcellGyGy.inventoryservice.business.dto.responses.create.CreateBrandResponse;
import com.turkcellGyGy.inventoryservice.business.dto.responses.create.CreateCarResponse;
import com.turkcellGyGy.inventoryservice.business.dto.responses.get.GetAllBrandsResponse;
import com.turkcellGyGy.inventoryservice.business.dto.responses.get.GetAllCarsResponse;
import com.turkcellGyGy.inventoryservice.business.dto.responses.get.GetBrandResponse;
import com.turkcellGyGy.inventoryservice.business.dto.responses.get.GetCarResponse;
import com.turkcellGyGy.inventoryservice.business.dto.responses.update.UpdateBrandResponse;
import com.turkcellGyGy.inventoryservice.business.dto.responses.update.UpdateCarResponse;
import com.turkcellGyGy.inventoryservice.business.rules.BrandBusinessRules;
import com.turkcellGyGy.inventoryservice.entity.Brand;
import com.turkcellGyGy.inventoryservice.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
@AllArgsConstructor
public class BrandServiceImpl implements BrandService {

    private final BrandRepository repository;
    private final BrandBusinessRules rules;
    private final ModelMapperService mapper;

    @Override
    public List<GetAllBrandsResponse> getAll() {

        var brands = repository.findAll();

        var response = brands.stream().map(brand -> mapper.forResponse().map(brand, GetAllBrandsResponse.class)).toList();

        return response;


    }

    @Override
    public GetBrandResponse getById(UUID id) {

        var brand = repository.findById(id).orElseThrow();

        var response = mapper.forResponse().map(brand,GetBrandResponse.class);
        return response;
    }

    @Override
    public CreateBrandResponse add(CreateBrandRequest request) {

        var brand = mapper.forRequest().map(request,Brand.class);
        repository.save(brand);

        var response = mapper.forResponse().map(brand,CreateBrandResponse.class);

        return response;
    }

    @Override
    public UpdateBrandResponse update(UUID id, UpdateBrandRequest request) {
        rules.checkIfBrandExists(id);
        var brand = mapper.forRequest().map(request, Brand.class);
        brand.setId(id);
        repository.save(brand);
        var response = mapper.forResponse().map(brand, UpdateBrandResponse.class);

        return response;
    }

    @Override
    public void delete(UUID id) {
        rules.checkIfBrandExists(id);
        repository.deleteById(id);
    }


}
