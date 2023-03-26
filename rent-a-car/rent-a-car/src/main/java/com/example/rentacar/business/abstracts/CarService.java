package com.example.rentacar.business.abstracts;

import com.example.rentacar.business.dto.requests.create.car.CreateCarRequest;
import com.example.rentacar.business.dto.requests.update.car.UpdateCarRequest;
import com.example.rentacar.business.dto.responses.create.car.CreateCarResponse;
import com.example.rentacar.business.dto.responses.get.car.GetAllCarsResponse;
import com.example.rentacar.business.dto.responses.get.car.GetCarResponse;
import com.example.rentacar.business.dto.responses.update.car.UpdateCarResponse;

import java.util.List;


public interface CarService {

    List<GetAllCarsResponse> getAll();
    GetCarResponse getById(long id);
    CreateCarResponse add(CreateCarRequest car);
    UpdateCarResponse update(long id, UpdateCarRequest car);
    void delete(long id);
}
