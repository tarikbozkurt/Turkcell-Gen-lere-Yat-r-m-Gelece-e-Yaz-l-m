package com.example.ecommercesystem.service.dto.response.create.category;

import com.example.ecommercesystem.entity.Product;

import java.util.HashSet;
import java.util.Set;

public class CreateCategoryResponse {

    private String name;
    private String description;
    private Set<Product> products = new HashSet<>();


    public CreateCategoryResponse() {
    }

    public CreateCategoryResponse(String name, String description, Set<Product> products) {
        this.name = name;
        this.description = description;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
