package com.example.ecommercesystem.api;


import com.example.ecommercesystem.entity.Category;
import com.example.ecommercesystem.service.CategoryService;
import com.example.ecommercesystem.service.ProductService;
import com.example.ecommercesystem.service.dto.request.create.category.CreateCategoryRequest;
import com.example.ecommercesystem.service.dto.response.create.category.CreateCategoryResponse;
import com.example.ecommercesystem.service.dto.response.get.category.GetCategoryResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService service;


    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping()
    public List<GetCategoryResponse> getAll(){
        return service.getAll();
    }


    @PostMapping()
    public CreateCategoryResponse create(@RequestBody CreateCategoryRequest request){
        return service.create(request);
    }
}
