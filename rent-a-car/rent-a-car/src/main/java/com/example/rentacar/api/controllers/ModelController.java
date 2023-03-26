package com.example.rentacar.api.controllers;


import com.example.rentacar.business.abstracts.ModelService;
import com.example.rentacar.business.dto.requests.create.model.CreateModelRequest;
import com.example.rentacar.business.dto.requests.update.model.UpdateModelRequest;
import com.example.rentacar.business.dto.responses.create.model.CreateModelResponse;
import com.example.rentacar.business.dto.responses.get.model.GetAllModelsResponse;
import com.example.rentacar.business.dto.responses.get.model.GetModelResponse;
import com.example.rentacar.business.dto.responses.update.model.UpdateModelResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/model")
public class ModelController {

    private final ModelService service;

    public ModelController(ModelService service) {
        this.service = service;
    }


    @GetMapping("{id}")
    public GetModelResponse getModel(@PathVariable("id") long id) {
        return service.getById(id);

    }

    @GetMapping("/models")
    public List<GetAllModelsResponse> getAllModels(){
        return service.getAll();
    }

    @PostMapping()
    public CreateModelResponse createModel(@RequestBody CreateModelRequest request){
        return service.add(request);
    }

    @PutMapping("{id}")
    public UpdateModelResponse updateModel(@PathVariable("id") long id, @RequestBody UpdateModelRequest request){

        return service.update(id,request);
    }

    @DeleteMapping("{id}")
    public void deleteModel(@PathVariable("id") long id){
        service.delete(id);
    }


}
