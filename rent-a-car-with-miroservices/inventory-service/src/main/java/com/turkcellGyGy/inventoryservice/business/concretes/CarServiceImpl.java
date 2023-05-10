package com.turkcellGyGy.inventoryservice.business.concretes;


import com.turkcellGyGy.commonpackage.utils.mappers.ModelMapperService;
import com.turkcellGyGy.inventoryservice.business.abstracts.CarService;
import com.turkcellGyGy.inventoryservice.business.dto.requests.create.CreateCarRequest;
import com.turkcellGyGy.inventoryservice.business.dto.requests.update.UpdateCarRequest;
import com.turkcellGyGy.inventoryservice.business.dto.responses.create.CreateCarResponse;
import com.turkcellGyGy.inventoryservice.business.dto.responses.get.GetAllCarsResponse;
import com.turkcellGyGy.inventoryservice.business.dto.responses.get.GetCarResponse;
import com.turkcellGyGy.inventoryservice.business.dto.responses.update.UpdateCarResponse;
import com.turkcellGyGy.inventoryservice.business.rules.CarBusinessRules;
import com.turkcellGyGy.inventoryservice.entity.Car;
import com.turkcellGyGy.inventoryservice.entity.enums.State;
import com.turkcellGyGy.inventoryservice.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository repository;
    private final ModelMapperService mapper;
    private final CarBusinessRules rules;

    @Override
    public List<GetAllCarsResponse> getAll() {
       //List<Car> car = repository.findAll();
        var cars = repository.findAll();

        var response = cars
                .stream()
                .map( car -> mapper.forResponse().map(car,GetAllCarsResponse.class)).toList();

        return response;

    }

    @Override
    public GetCarResponse getById(UUID id) {
        rules.checkIfCarExists(id);
        var car =  repository.findById(id).orElseThrow();
        var response = mapper.forResponse().map(car,GetCarResponse.class);

        return response;
    }

    @Override
    public CreateCarResponse add(CreateCarRequest request) {
        rules.checkIfCarPlateExists(request.getPlate().toString());
        var car = mapper.forRequest().map(request,Car.class);
        car.setId(null);
        car.setState(State.AVAILABLE);
        repository.save(car);
        var response = mapper.forResponse().map(car,CreateCarResponse.class);

        return response;
    }

    @Override
    public UpdateCarResponse update(UUID id, UpdateCarRequest request){
        rules.checkIfCarExists(id);
        var car = mapper.forRequest().map(request,Car.class);

        car.setId(id);
        repository.save(car);

        var response = mapper.forResponse().map(car,UpdateCarResponse.class);
        return response;
    }

    @Override
    public void delete(UUID id) {
        rules.checkIfCarExists(id);
        repository.deleteById(id);

    }
}
