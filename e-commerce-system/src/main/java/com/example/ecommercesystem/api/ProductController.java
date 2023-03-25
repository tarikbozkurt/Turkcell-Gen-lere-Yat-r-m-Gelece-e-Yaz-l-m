package com.example.ecommercesystem.api;


import com.example.ecommercesystem.entity.Product;
import com.example.ecommercesystem.service.ProductService;
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
    public List<Product> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable("id") int id){
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product add(@RequestBody Product brand){
        return service.create(brand);
    }

    @PutMapping("/{id}")
    public Product update( @PathVariable("id") int id, @RequestBody Product product){
        return service.update(id,product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        service.delete(id);
    }
}
