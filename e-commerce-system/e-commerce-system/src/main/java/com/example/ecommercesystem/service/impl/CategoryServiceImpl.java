package com.example.ecommercesystem.service.impl;

import com.example.ecommercesystem.entity.Category;
import com.example.ecommercesystem.repository.CategoryRepository;
import com.example.ecommercesystem.service.CategoryService;
import com.example.ecommercesystem.service.dto.request.create.category.CreateCategoryRequest;
import com.example.ecommercesystem.service.dto.request.update.category.UpdateCategoryRequest;
import com.example.ecommercesystem.service.dto.response.create.category.CreateCategoryResponse;
import com.example.ecommercesystem.service.dto.response.get.category.GetCategoryResponse;
import com.example.ecommercesystem.service.dto.response.update.category.UpdateCategoryResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }


    @Override
    public CreateCategoryResponse create(CreateCategoryRequest category) {
        Category categoryDB = modelMapper.map(category,Category.class);

        repository.save(categoryDB);

        CreateCategoryResponse response = modelMapper.map(categoryDB, CreateCategoryResponse.class);

        return response;
    }

    @Override
    public UpdateCategoryResponse update(long id, UpdateCategoryRequest request) {

        Category categoryDB = modelMapper.map(request,Category.class);

        categoryDB.setId(id);

        repository.save(categoryDB);

        UpdateCategoryResponse response = modelMapper.map(categoryDB,UpdateCategoryResponse.class);

        return response;
    }

    @Override
    public void delete(long id) {
        checkIfBrandExists(id);
        repository.deleteById(id);
    }

    @Override
    public GetCategoryResponse getById(long id) {

        Category category = repository.findById(id).orElseThrow();

        GetCategoryResponse response = modelMapper.map(category, GetCategoryResponse.class);

        return response;
    }

    @Override
    public List<GetCategoryResponse> getAll() {

        List<Category> categories = repository.findAll();

        List<GetCategoryResponse> response = categories
                .stream()
                .map(category -> modelMapper.map(category,GetCategoryResponse.class)).toList();


        return response;
    }

    private void checkIfBrandExists(long id){
        if(!repository.existsById(id)) throw new IllegalArgumentException("ID NOT FOUND !");

    }
}
