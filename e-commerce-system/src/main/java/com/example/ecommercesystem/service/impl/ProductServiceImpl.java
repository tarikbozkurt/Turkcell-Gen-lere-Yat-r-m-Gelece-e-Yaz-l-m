package com.example.ecommercesystem.service.impl;

import com.example.ecommercesystem.entity.Product;
import com.example.ecommercesystem.repository.ProductRepository;
import com.example.ecommercesystem.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    //baska bir yere atama yapmayacaksak / degismeyecek
    //autowired oldugu icin product service in memory e otomatik erisir
    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.repository = productRepository;
    }

    @Override
    public Product create(Product product) {
        //! metod uzerinden git kurallar icin
        //Metodlari ceken bir metod daha yazarsan daha temiz olur.
        // illegalargument runtime tutuyor zaten..
        //Exception da olur / runtime da olur

        if(product.getUnitPrice() <= 0) throw new IllegalArgumentException("Unit Price cannot be less than zero.");
        if(product.getQuantity() < 0 ) throw new IllegalArgumentException("Quantity cannot be less than or equal to zero")  ;
        if(product.getDescription().length() <10 || product.getDescription().length() >50) throw new IllegalArgumentException("Description length must be between 10 and 50 characters.");
        System.out.println("Created New Product: "+product.getName());
        return  repository.save(product);


    }

    @Override
    public Product update(long id, Product product) {
        checkIfBrandExists(id);
        if(product.getUnitPrice() <= 0) throw new IllegalArgumentException("Unit Price cannot be less than zero.");
        if(product.getQuantity() < 0 ) throw new IllegalArgumentException("Quantity cannot be less than or equal to zero")  ;
        if(product.getDescription().length() <10 || product.getDescription().length() >50) throw new IllegalArgumentException("Description length must be between 10 and 50 characters.");
        product.setId(id);
        System.out.println("Updated Product: "+product.getName());
        return repository.save(product);

    }

    @Override
    public void delete(long id) {
        checkIfBrandExists(id);
        repository.deleteById(id);
    }

    @Override
    public Product getById(long id) {
        checkIfBrandExists(id);
        return repository.findById(id).orElseThrow();
    }

    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }


    //! Business Rules Here !

    private void checkIfBrandExists(long id){
        if(!repository.existsById(id)) throw new IllegalArgumentException("ID NOT FOUND !");

    }



}
