package com.example.rentacar.business.concretes;

import com.example.rentacar.business.abstracts.CarService;
import com.example.rentacar.business.dto.requests.create.car.CreateCarRequest;
import com.example.rentacar.business.dto.requests.update.car.UpdateCarRequest;
import com.example.rentacar.business.dto.responses.create.car.CreateCarResponse;
import com.example.rentacar.business.dto.responses.get.car.GetAllCarsResponse;
import com.example.rentacar.business.dto.responses.get.car.GetCarResponse;
import com.example.rentacar.business.dto.responses.update.car.UpdateCarResponse;
import com.example.rentacar.entity.Car;
import com.example.rentacar.entity.enumerations.State;
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
    public List<GetAllCarsResponse> getAll(boolean includeMaintenance) {
       List<Car> cars = filterCarsByMaintenanceState(includeMaintenance);
       List<GetAllCarsResponse> response = cars
               .stream()
               .map( car -> modelMapper.map(car,GetAllCarsResponse.class)).toList();



        return response;
    }

    @Override
    public GetCarResponse getById(long id) {
        checkIfCarExists(id);
        Car car = repository.findById(id).orElseThrow();

        GetCarResponse response = modelMapper.map(car,GetCarResponse.class);
        return response;
    }

    @Override
    public CreateCarResponse add(CreateCarRequest request) {

        Car car = modelMapper.map(request,Car.class);
        car.setId(0);
        car.setState(State.AVAILABLE);
        repository.save(car);
        CreateCarResponse response = modelMapper.map(car,CreateCarResponse.class);


        return response;
    }

    @Override
    public UpdateCarResponse update(long id, UpdateCarRequest request) {
        checkIfCarExists(id);
        Car car = modelMapper.map(request,Car.class);
        car.setId(id);
        repository.save(car);

        UpdateCarResponse response = modelMapper.map(car,UpdateCarResponse.class);
        return response;
    }

    @Override
    public void delete(long id) {
        checkIfCarExists(id);
        repository.deleteById(id);
    }

    @Override
    public void changeState(long carId, State state) {

        Car car = repository.findById(carId).orElseThrow();
        car.setState(state);
        repository.save(car);
    }

    private void checkIfCarExists(long id){

        if(!repository.existsById(id)){
            throw new IllegalArgumentException("zaten mevcut");
        }
    }
    private List<Car> filterCarsByMaintenanceState(boolean includeMaintenance) {
        if (includeMaintenance) {
            return repository.findAll();
        }

        return repository.findAllByStateIsNot(State.MAINTENANCE);
    }
}

