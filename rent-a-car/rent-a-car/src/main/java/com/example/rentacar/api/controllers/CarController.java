package com.example.rentacar.api.controllers;


import com.example.rentacar.business.abstracts.CarService;
import com.example.rentacar.business.dto.requests.create.car.CreateCarRequest;
import com.example.rentacar.business.dto.requests.update.car.UpdateCarRequest;
import com.example.rentacar.business.dto.responses.create.car.CreateCarResponse;
import com.example.rentacar.business.dto.responses.get.car.GetAllCarsResponse;
import com.example.rentacar.business.dto.responses.get.car.GetCarResponse;
import com.example.rentacar.business.dto.responses.update.car.UpdateCarResponse;
import com.example.rentacar.entity.enumerations.State;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarController {


    private final CarService service;

    public CarController(CarService service) {
        this.service = service;
    }


    //GET - PUT- DELETE -UPDATE

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateCarResponse createCarResponse(@RequestBody CreateCarRequest request){

        return service.add(request);

    }
    @GetMapping("/{id}")
    public GetCarResponse getCarResponse(@PathVariable("id") long id){
       return service.getById(id);
    }

    @GetMapping("/cars")
    public List<GetAllCarsResponse> getAllCarsResponses(@RequestParam(required = false) State state){
        return service.getAll(state);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") long id){
        service.delete(id);

    }

    @PutMapping("/update/{id}")
    public UpdateCarResponse updateCarResponse(@PathVariable("id") long id,  @RequestBody UpdateCarRequest request){

        return service.update(id,request);
    }

}
