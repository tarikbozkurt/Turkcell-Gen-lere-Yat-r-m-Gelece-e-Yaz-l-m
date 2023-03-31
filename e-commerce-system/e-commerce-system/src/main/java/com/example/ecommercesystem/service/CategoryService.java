package com.example.ecommercesystem.service;

import com.example.ecommercesystem.entity.Category;
import com.example.ecommercesystem.entity.Product;
import com.example.ecommercesystem.service.dto.request.create.category.CreateCategoryRequest;
import com.example.ecommercesystem.service.dto.request.update.category.UpdateCategoryRequest;
import com.example.ecommercesystem.service.dto.response.create.category.CreateCategoryResponse;
import com.example.ecommercesystem.service.dto.response.get.category.GetCategoryResponse;
import com.example.ecommercesystem.service.dto.response.update.category.UpdateCategoryResponse;

import java.util.List;

public interface CategoryService {

    CreateCategoryResponse create(CreateCategoryRequest category);
    UpdateCategoryResponse update(long id, UpdateCategoryRequest category);
    void delete(long id);

    GetCategoryResponse getById(long id);

    List<GetCategoryResponse> getAll();
}
