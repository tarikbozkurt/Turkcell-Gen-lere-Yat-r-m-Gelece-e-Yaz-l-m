package com.example.ecommercesystem.service;



import com.example.ecommercesystem.service.dto.request.create.category.CreateCategoryRequest;
import com.example.ecommercesystem.service.dto.request.create.product.CreateProductRequest;
import com.example.ecommercesystem.service.dto.request.update.product.UpdateProductRequest;
import com.example.ecommercesystem.service.dto.response.create.product.CreateProductResponse;
import com.example.ecommercesystem.service.dto.response.get.product.GetProductResponse;
import com.example.ecommercesystem.service.dto.response.update.product.UpdateProductResponse;

import java.util.List;

public interface ProductService {
    CreateProductResponse create(CreateProductRequest product);
    UpdateProductResponse update(long id, UpdateProductRequest product);
    void delete(long id);

    GetProductResponse getById(long id);

    List<GetProductResponse> getAll();


}
