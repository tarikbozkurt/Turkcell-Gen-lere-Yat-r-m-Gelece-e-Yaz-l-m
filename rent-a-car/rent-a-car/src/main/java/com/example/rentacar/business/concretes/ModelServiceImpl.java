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
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {


    private final ModelRepository repository;
    private final ModelMapper modelMapper;

    public ModelServiceImpl(ModelRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }




    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = repository.findAll();

        List<GetAllModelsResponse> response= models
                .stream()
                .map(model -> modelMapper.map(model,GetAllModelsResponse.class)).toList();



        return response;
    }

    @Override
    public GetModelResponse getById(long id) {
       Model model = repository.findById(id).orElseThrow();

        GetModelResponse response = modelMapper.map(model,GetModelResponse.class);



       return response;
    }

    @Override
    public CreateModelResponse add(CreateModelRequest request) {

        Model model = modelMapper.map(request,Model.class);

        repository.save(model);

        CreateModelResponse response = modelMapper.map(model,CreateModelResponse.class);

        return response;
    }

    @Override
    public UpdateModelResponse update(long id, UpdateModelRequest request) {
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
