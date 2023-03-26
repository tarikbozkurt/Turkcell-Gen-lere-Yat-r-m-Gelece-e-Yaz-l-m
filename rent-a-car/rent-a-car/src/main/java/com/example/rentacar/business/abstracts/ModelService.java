package com.example.rentacar.business.abstracts;

import com.example.rentacar.business.dto.requests.create.model.CreateModelRequest;
import com.example.rentacar.business.dto.requests.update.model.UpdateModelRequest;
import com.example.rentacar.business.dto.responses.create.model.CreateModelResponse;
import com.example.rentacar.business.dto.responses.get.model.GetAllModelsResponse;
import com.example.rentacar.business.dto.responses.get.model.GetModelResponse;
import com.example.rentacar.business.dto.responses.update.model.UpdateModelResponse;
import com.example.rentacar.entity.Model;

import java.util.List;

public interface ModelService {

    List<GetAllModelsResponse> getAll();
    GetModelResponse getById(long id);
    CreateModelResponse add(CreateModelRequest request);
    UpdateModelResponse update(long id, UpdateModelRequest request);
    void delete(long id);
}
