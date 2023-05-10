package com.turkcellGyGy.inventoryservice.business.concretes;

import com.turkcellGyGy.commonpackage.utils.mappers.ModelMapperService;
import com.turkcellGyGy.inventoryservice.business.abstracts.ModelService;
import com.turkcellGyGy.inventoryservice.business.dto.requests.create.CreateModelRequest;
import com.turkcellGyGy.inventoryservice.business.dto.requests.update.UpdateModelRequest;
import com.turkcellGyGy.inventoryservice.business.dto.responses.create.CreateModelResponse;
import com.turkcellGyGy.inventoryservice.business.dto.responses.get.GetAllModelsResponse;
import com.turkcellGyGy.inventoryservice.business.dto.responses.get.GetModelResponse;
import com.turkcellGyGy.inventoryservice.business.dto.responses.update.UpdateModelResponse;
import com.turkcellGyGy.inventoryservice.business.rules.ModelBusinessRules;
import com.turkcellGyGy.inventoryservice.entity.Car;
import com.turkcellGyGy.inventoryservice.entity.Model;
import com.turkcellGyGy.inventoryservice.repository.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
@AllArgsConstructor
public class ModelServiceImpl implements ModelService {

    private final ModelRepository repository;
    private final ModelMapperService mapper;
    private final ModelBusinessRules rules;


    @Override
    public List<GetAllModelsResponse> getAll() {

        var cars = repository.findAll();

        var response = cars
                .stream()
                .map(car -> mapper.forResponse().map(car, GetAllModelsResponse.class)).toList();

        return response;
    }

    @Override
    public GetModelResponse getById(UUID id) {
        rules.checkIfModelExists(id);

        var model = repository.findById(id).orElseThrow();

        var response = mapper.forResponse().map(model, GetModelResponse.class);

        return response;
    }

    @Override
    public CreateModelResponse add(CreateModelRequest request) {

        var model = mapper.forRequest().map(request, Model.class);
        repository.save(model);
        var response = mapper.forResponse().map(model,CreateModelResponse.class);

        return response;
    }

    @Override
    public UpdateModelResponse update(UUID id, UpdateModelRequest request) {

        rules.checkIfModelExists(id);
        var car  = mapper.forRequest().map(request,Model.class);

        car.setId(id);
        repository.save(car);
        var response = mapper.forResponse().map(car,UpdateModelResponse.class);


        return response;
    }

    @Override
    public void delete(UUID id) {
        rules.checkIfModelExists(id);
        repository.deleteById(id);

    }
}
