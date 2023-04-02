package com.example.rentacar.business.abstracts;

import com.example.rentacar.business.dto.requests.create.maintenances.CreateMaintenancesRequest;
import com.example.rentacar.business.dto.requests.create.model.CreateModelRequest;
import com.example.rentacar.business.dto.requests.update.maintenances.UpdateMaintenancesRequest;
import com.example.rentacar.business.dto.requests.update.model.UpdateModelRequest;
import com.example.rentacar.business.dto.responses.create.maintenances.CreateMaintenancesResponse;
import com.example.rentacar.business.dto.responses.create.model.CreateModelResponse;
import com.example.rentacar.business.dto.responses.get.maintenances.GetAllMaintenancesResponse;
import com.example.rentacar.business.dto.responses.get.maintenances.GetMaintenancesResponse;
import com.example.rentacar.business.dto.responses.get.model.GetAllModelsResponse;
import com.example.rentacar.business.dto.responses.get.model.GetModelResponse;
import com.example.rentacar.business.dto.responses.update.maintenances.UpdateMaintenancesResponse;
import com.example.rentacar.business.dto.responses.update.model.UpdateModelResponse;

import java.util.List;



public interface MaintenancesService {


    List<GetAllMaintenancesResponse> getAll();
    GetMaintenancesResponse getById(long id);
    CreateMaintenancesResponse add(CreateMaintenancesRequest request);
    UpdateMaintenancesResponse update(long id, UpdateMaintenancesRequest request);
    void delete(long id);
}
