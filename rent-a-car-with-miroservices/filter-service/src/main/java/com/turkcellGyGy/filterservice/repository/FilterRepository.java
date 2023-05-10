package com.turkcellGyGy.filterservice.repository;

import com.turkcellGyGy.filterservice.entities.Filter;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface FilterRepository extends MongoRepository<Filter, UUID> {



}
