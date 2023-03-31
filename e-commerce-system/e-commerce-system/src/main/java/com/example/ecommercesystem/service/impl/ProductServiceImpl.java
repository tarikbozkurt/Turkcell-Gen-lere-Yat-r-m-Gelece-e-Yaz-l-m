package com.example.ecommercesystem.service.impl;

import com.example.ecommercesystem.entity.Product;
import com.example.ecommercesystem.repository.ProductRepository;
import com.example.ecommercesystem.service.ProductService;
import com.example.ecommercesystem.service.dto.request.create.product.CreateProductRequest;
import com.example.ecommercesystem.service.dto.request.update.product.UpdateProductRequest;
import com.example.ecommercesystem.service.dto.response.create.category.CreateCategoryResponse;
import com.example.ecommercesystem.service.dto.response.create.product.CreateProductResponse;
import com.example.ecommercesystem.service.dto.response.get.product.GetProductResponse;
import com.example.ecommercesystem.service.dto.response.update.product.UpdateProductResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    //baska bir yere atama yapmayacaksak / degismeyecek
    //autowired oldugu icin product service in memory e otomatik erisir
    private final ProductRepository repository;
    private final ModelMapper modelMapper;
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.repository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CreateProductResponse create(CreateProductRequest product) {
        //! metod uzerinden git kurallar icin
        //Metodlari ceken bir metod daha yazarsan daha temiz olur.
        // illegalargument runtime tutuyor zaten..
        //Exception da olur / runtime da olur
        if(product.getUnitPrice() <= 0) throw new IllegalArgumentException("Unit Price cannot be less than zero.");
        if(product.getQuantity() < 0 ) throw new IllegalArgumentException("Quantity cannot be less than or equal to zero")  ;
        if(product.getDescription().length() <10 || product.getDescription().length() >50) throw new IllegalArgumentException("Description length must be between 10 and 50 characters.");


        Product productDtoDb = modelMapper.map(product,Product.class);

        repository.save(productDtoDb);
        System.out.println("Created New Product: "+product.getName());

        return modelMapper.map(productDtoDb,CreateProductResponse.class);




    }



    @Override
    public UpdateProductResponse update(long id, UpdateProductRequest request) {
        checkIfBrandExists(id);
        if(request.getUnitPrice() <= 0) throw new IllegalArgumentException("Unit Price cannot be less than zero.");
        if(request.getQuantity() < 0 ) throw new IllegalArgumentException("Quantity cannot be less than or equal to zero")  ;
        if(request.getDescription().length() <10 || request.getDescription().length() >50) throw new IllegalArgumentException("Description length must be between 10 and 50 characters.");
        Product product = modelMapper.map(request,Product.class);
        product.setId(id);
        repository.save(product);
        UpdateProductResponse response = modelMapper.map(product,UpdateProductResponse.class);
        System.out.println("Updated Product: "+product.getName());

        return response;

    }

    @Override
    public void delete(long id) {
        checkIfBrandExists(id);
        repository.deleteById(id);
    }

    @Override
    public GetProductResponse getById(long id) {
        checkIfBrandExists(id);
        Product product = repository.findById(id).orElseThrow();

        GetProductResponse response = modelMapper.map(product,GetProductResponse.class);
        return response;
    }

    @Override
    public List<GetProductResponse> getAll() {

        List<Product> products = repository.findAll();

        List<GetProductResponse> response = products
                .stream()
                .map(product -> modelMapper.map(product,GetProductResponse.class)).toList();


        return response;
    }


    //! Business Rules Here !

    private void checkIfBrandExists(long id){
        if(!repository.existsById(id)) throw new IllegalArgumentException("ID NOT FOUND !");

    }



}
