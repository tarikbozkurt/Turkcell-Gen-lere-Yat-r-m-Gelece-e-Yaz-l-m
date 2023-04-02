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
    public List<GetAllCarsResponse> getAll(State state) {

        List<Car> carList;
        if (state == null) {
            carList = repository.findAll();
        } else {
            carList = repository.findAllByState(state);
        }


        List<GetAllCarsResponse> response = carList
                .stream()
                .map(car ->
            modelMapper.map(car,GetAllCarsResponse.class)).toList();

        return response;



    }

    @Override
    public GetCarResponse getById(long id) {
        checkIfCarExists(id);
        Car car = repository.findById(id).orElseThrow();


        GetCarResponse carDto = modelMapper.map(car,GetCarResponse.class);


        return carDto;

    }

    @Override
    public CreateCarResponse add(CreateCarRequest request) {
        checkIfCarExistsByPlate(request.getPlate());
        Car car = modelMapper.map(request,Car.class);
        car.setId(0);
        Car carResponse = repository.save(car);

        CreateCarResponse response = modelMapper.map(carResponse,CreateCarResponse.class);

        return  response;

    }

    @Override
    public UpdateCarResponse update(long id, UpdateCarRequest request) {
        checkIfCarExists(id);

        Car car = modelMapper.map(request, Car.class);
        car.setId(id);
        Car createdCar = repository.save(car);

        UpdateCarResponse response = modelMapper.map(createdCar, UpdateCarResponse.class);

        return response;
    }

    @Override
    public void delete(long id) {

        checkIfCarExists(id);
        repository.deleteById(id);
    }

    @Override
    public Car findCarById(long id) {
        return repository.findById(id).orElseThrow();
    }


    private void checkIfCarExists(long id){
        if(!repository.existsById(id))
            throw new IllegalArgumentException("ID NOT FOUND !");

    }

    private void checkIfCarExistsByPlate(String plate) {
        if (repository.existsByPlateIgnoreCase(plate)) {
            throw new RuntimeException("Car already exists");
        }
    }
}
