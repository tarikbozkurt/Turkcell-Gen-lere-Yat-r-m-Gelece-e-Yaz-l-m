package com.example.ecommercesystem.service;

import com.example.ecommercesystem.entity.Product;

import java.util.List;

public interface ProductService {
    Product create(Product product);
    Product update(long id, Product product);
    void delete(long id);

    Product getById(long id);

    List<Product> getAll();


}
