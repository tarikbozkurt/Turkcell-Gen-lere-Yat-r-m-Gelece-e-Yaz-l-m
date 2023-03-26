package com.example.rentacar.api.controllers;


import com.example.rentacar.business.abstracts.BrandService;
import com.example.rentacar.business.dto.requests.create.brand.CreateBrandRequest;
import com.example.rentacar.business.dto.requests.update.brand.UpdateBrandRequest;
import com.example.rentacar.business.dto.responses.create.brand.CreateBrandResponse;
import com.example.rentacar.business.dto.responses.get.brand.GetAllBrandsResponse;
import com.example.rentacar.business.dto.responses.get.brand.GetBrandResponse;
import com.example.rentacar.business.dto.responses.get.car.GetAllCarsResponse;
import com.example.rentacar.business.dto.responses.get.car.GetCarResponse;
import com.example.rentacar.business.dto.responses.update.brand.UpdateBrandResponse;
import com.example.rentacar.entity.Brand;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brand")
public class BrandController {

    private final BrandService service;

    public BrandController(BrandService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateBrandResponse add(@RequestBody CreateBrandRequest request){
        return service.add(request);
    }

    @GetMapping("/brands")
    public List<GetAllBrandsResponse> getAllBrandsResponses(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetBrandResponse getBrandResponse(@PathVariable("id") long id){
        return service.getById(id);
    }
    @PutMapping("/{id}")
    public UpdateBrandResponse update(@PathVariable("id") long id, @RequestBody UpdateBrandRequest request){
        return service.update(id,request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        service.delete(id);
    }

}
