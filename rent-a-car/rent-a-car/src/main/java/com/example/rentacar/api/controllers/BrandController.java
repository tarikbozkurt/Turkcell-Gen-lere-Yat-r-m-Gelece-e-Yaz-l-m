package com.example.rentacar.api.controllers;


import com.example.rentacar.business.abstracts.BrandService;
import com.example.rentacar.entites.Brand;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandController {


    private final BrandService service;

    public BrandController(BrandService service) {
        this.service = service;
    }



    @GetMapping
    public List<Brand> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Brand getById(@PathVariable("id") int id){
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Brand add(@RequestBody Brand brand){
        return service.add(brand);
    }

    @PutMapping("/{id}")
    public Brand update( @PathVariable("id") int id, @RequestBody Brand brand){
        return service.update(id,brand);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        service.delete(id);
    }



}
