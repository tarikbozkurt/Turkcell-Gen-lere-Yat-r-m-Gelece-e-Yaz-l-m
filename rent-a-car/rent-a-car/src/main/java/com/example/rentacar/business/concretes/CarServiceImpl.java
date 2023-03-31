package com.example.rentacar.business.concretes;

import com.example.rentacar.business.abstracts.CarService;
import com.example.rentacar.business.dto.requests.create.car.CreateCarRequest;
import com.example.rentacar.business.dto.requests.update.car.UpdateCarRequest;
import com.example.rentacar.business.dto.responses.create.car.CreateCarResponse;
import com.example.rentacar.business.dto.responses.get.car.GetAllCarsResponse;
import com.example.rentacar.business.dto.responses.get.car.GetCarResponse;
import com.example.rentacar.business.dto.responses.update.car.UpdateCarResponse;
import com.example.rentacar.entity.Car;
import com.example.rentacar.repository.CarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository repository;

    private final ModelMapper modelMapper;


    public CarServiceImpl(CarRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<GetAllCarsResponse> getAll() {

        List<Car> cars = repository.findAll();

        List<GetAllCarsResponse> response = cars
                .stream()
                .map(car ->
            modelMapper.map(car,GetAllCarsResponse.class)).toList();

        return response;



    }

    @Override
    public GetCarResponse getById(long id) {

        Car car = repository.findById(id).orElseThrow();


        GetCarResponse carDto = modelMapper.map(car,GetCarResponse.class);


        return carDto;

    }

    @Override
    public CreateCarResponse add(CreateCarRequest request) {

        Car car = modelMapper.map(request,Car.class);

        repository.save(car);

        CreateCarResponse response = modelMapper.map(car,CreateCarResponse.class);

        return  response;

    }

    @Override
    public UpdateCarResponse update(long id, UpdateCarRequest request) {
        checkIfBrandExists(id);


    // We can use request id for saving like save data method.. ?

        return null;
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }


    private void checkIfBrandExists(long id){
        if(!repository.existsById(id)) throw new IllegalArgumentException("ID NOT FOUND !");

    }
}
