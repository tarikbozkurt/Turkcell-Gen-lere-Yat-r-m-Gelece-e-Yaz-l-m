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
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository repository;

    public CarServiceImpl(CarRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<GetAllCarsResponse> getAll() {

        List<Car> cars = repository.findAll();

        List<GetAllCarsResponse> response = new ArrayList<>();

        for (Car car : cars) {

            response.add(new GetAllCarsResponse(car.getId(),car.getModelYear(),car.getPlate(),car.getState(),car.getDailyPrice()));

        }

        return response;


    }

    @Override
    public GetCarResponse getById(long id) {

        Car car = repository.findById(id).orElseThrow();

        GetCarResponse response = new GetCarResponse(car.getId(), car.getModelYear(),car.getPlate(), car.getState(), car.getDailyPrice());

        return response;

    }

    @Override
    public CreateCarResponse add(CreateCarRequest request) {

        Car car = new Car();

        car.setDailyPrice(request.getDailyPrice());
        car.setPlate(request.getPlate());
        car.setState(request.getState());
        car.setModelYear(request.getModelYear());
        repository.save(car);


        CreateCarResponse response = new CreateCarResponse();

        response.setId(car.getId());
        response.setDailyPrice(car.getDailyPrice());
        response.setPlate(car.getPlate());
        response.setModelYear(car.getModelYear());
        response.setState(car.getState());

        return  response;

    }

    @Override
    public UpdateCarResponse update(long id, UpdateCarRequest request) {
        checkIfBrandExists(id);

        Car car = repository.findById(id).orElseThrow();

        car.setModelYear(request.getModelYear());
        car.setState(request.getState());
        car.setPlate(request.getPlate());
        car.setDailyPrice(request.getDailyPrice());

        repository.save(car);


        UpdateCarResponse response = new UpdateCarResponse();

        response.setDailyPrice(car.getDailyPrice());
        response.setPlate(car.getPlate());
        response.setModelYear(car.getModelYear());
        response.setState(car.getState());


        return response;
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }


    private void checkIfBrandExists(long id){
        if(!repository.existsById(id)) throw new IllegalArgumentException("ID NOT FOUND !");

    }
}
