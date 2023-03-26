package com.example.rentacar.business.concretes;

import com.example.rentacar.business.abstracts.ModelService;
import com.example.rentacar.business.dto.requests.create.model.CreateModelRequest;
import com.example.rentacar.business.dto.requests.update.model.UpdateModelRequest;
import com.example.rentacar.business.dto.responses.create.model.CreateModelResponse;
import com.example.rentacar.business.dto.responses.get.model.GetAllModelsResponse;
import com.example.rentacar.business.dto.responses.get.model.GetModelResponse;
import com.example.rentacar.business.dto.responses.update.model.UpdateModelResponse;
import com.example.rentacar.entity.Model;
import com.example.rentacar.repository.ModelRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {


    private final ModelRepository repository;

    public ModelServiceImpl(ModelRepository repository) {
        this.repository = repository;
    }




    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = repository.findAll();

        List<GetAllModelsResponse> response = new ArrayList<>();

        for (Model model : models) {

            response.add(new GetAllModelsResponse(model.getId(),model.getName()));


        }
        return response;
    }

    @Override
    public GetModelResponse getById(long id) {
       Model model = repository.findById(id).orElseThrow();

       GetModelResponse response = new GetModelResponse(model.getId(),model.getName());

       return response;
    }

    @Override
    public CreateModelResponse add(CreateModelRequest request) {

        Model model = new Model();
        model.setName(request.getName());

        repository.save(model);

        CreateModelResponse response = new CreateModelResponse(model.getId(), model.getName());


        return response;
    }

    @Override
    public UpdateModelResponse update(long id, UpdateModelRequest request) {
        checkIfBrandExists(id);
        Model model = repository.findById(id).orElseThrow();
        model.setName(request.getName());
        repository.save(model);

        UpdateModelResponse response = new UpdateModelResponse(model.getName());

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
