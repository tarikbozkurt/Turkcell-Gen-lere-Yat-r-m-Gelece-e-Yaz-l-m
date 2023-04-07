package com.example.rentacar.business.abstracts;

import com.example.rentacar.business.dto.requests.create.car.CreateCarRequest;
import com.example.rentacar.business.dto.requests.update.car.UpdateCarRequest;
import com.example.rentacar.business.dto.responses.create.car.CreateCarResponse;
import com.example.rentacar.business.dto.responses.get.car.GetAllCarsResponse;
import com.example.rentacar.business.dto.responses.get.car.GetCarResponse;
import com.example.rentacar.business.dto.responses.update.car.UpdateCarResponse;
import com.example.rentacar.entity.Car;
import com.example.rentacar.entity.enumerations.State;

import java.util.List;


public interface CarService {

    List<GetAllCarsResponse> getAll(boolean includeMaintenance);
    GetCarResponse getById(long id);
    CreateCarResponse add(CreateCarRequest car);
    UpdateCarResponse update(long id, UpdateCarRequest car);
    void delete(long id);

    void changeState(long carId, State state);


}
