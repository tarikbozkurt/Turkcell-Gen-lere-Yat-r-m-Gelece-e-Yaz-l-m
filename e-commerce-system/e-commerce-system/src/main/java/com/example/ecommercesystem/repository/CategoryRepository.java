package com.example.ecommercesystem.repository;

import com.example.ecommercesystem.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {

}
