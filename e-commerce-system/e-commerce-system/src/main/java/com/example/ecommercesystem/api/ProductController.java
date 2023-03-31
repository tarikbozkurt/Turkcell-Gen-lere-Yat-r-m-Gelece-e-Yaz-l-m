package com.example.ecommercesystem.api;


import com.example.ecommercesystem.entity.Product;
import com.example.ecommercesystem.service.ProductService;
import com.example.ecommercesystem.service.dto.request.create.product.CreateProductRequest;
import com.example.ecommercesystem.service.dto.request.update.product.UpdateProductRequest;
import com.example.ecommercesystem.service.dto.response.create.product.CreateProductResponse;
import com.example.ecommercesystem.service.dto.response.get.product.GetProductResponse;
import com.example.ecommercesystem.service.dto.response.update.product.UpdateProductResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@RestController Api ile RestFull icin calisiyorsak, @Controller Mvc calisirken
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }



    @GetMapping
    public List<GetProductResponse> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetProductResponse getById(@PathVariable("id") int id){
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateProductResponse add(@RequestBody CreateProductRequest request){
        return service.create(request);
    }

    @PutMapping("/{id}")
    public UpdateProductResponse update(@PathVariable("id") int id, @RequestBody UpdateProductRequest request){
        return service.update(id,request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        service.delete(id);
    }
}
