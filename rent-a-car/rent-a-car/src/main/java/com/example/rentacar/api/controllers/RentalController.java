package com.example.rentacar.api.controllers;

import com.example.rentacar.business.abstracts.ModelService;
import com.example.rentacar.business.abstracts.RentalService;
import com.example.rentacar.business.dto.requests.create.model.CreateModelRequest;
import com.example.rentacar.business.dto.requests.create.rental.CreateRentalRequest;
import com.example.rentacar.business.dto.requests.update.model.UpdateModelRequest;
import com.example.rentacar.business.dto.requests.update.rental.UpdateRentalRequest;
import com.example.rentacar.business.dto.responses.create.model.CreateModelResponse;
import com.example.rentacar.business.dto.responses.create.rental.CreateRentalResponse;
import com.example.rentacar.business.dto.responses.get.model.GetAllModelsResponse;
import com.example.rentacar.business.dto.responses.get.model.GetModelResponse;
import com.example.rentacar.business.dto.responses.get.rental.GetAllRentalResponse;
import com.example.rentacar.business.dto.responses.get.rental.GetRentalResponse;
import com.example.rentacar.business.dto.responses.update.model.UpdateModelResponse;
import com.example.rentacar.business.dto.responses.update.rental.UpdateRentalResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/rental")
public class RentalController {

    private final RentalService service;

    public RentalController(RentalService service) {
        this.service = service;
    }


    @GetMapping("{id}")
    public GetRentalResponse getModel(@PathVariable("id") long id) {
        return service.getById(id);

    }

    @GetMapping("/rentals")
    public List<GetAllRentalResponse> getAllModels(){
        return service.getAll();
    }

    @PostMapping()
    public CreateRentalResponse createModel(@RequestBody CreateRentalRequest request){
        return service.add(request);
    }

    @PutMapping("{id}")
    public UpdateRentalResponse updateModel(@PathVariable("id") long id, @RequestBody UpdateRentalRequest request){

        return service.update(id,request);
    }

    @DeleteMapping("{id}")
    public void deleteModel(@PathVariable("id") long id){
        service.deleteById(id);
    }

}
