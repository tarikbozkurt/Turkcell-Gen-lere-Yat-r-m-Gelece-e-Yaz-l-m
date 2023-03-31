package com.example.ecommercesystem.repository;

import com.example.ecommercesystem.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> { //wrapper hali int ->Integer long -> Long vb.


}
