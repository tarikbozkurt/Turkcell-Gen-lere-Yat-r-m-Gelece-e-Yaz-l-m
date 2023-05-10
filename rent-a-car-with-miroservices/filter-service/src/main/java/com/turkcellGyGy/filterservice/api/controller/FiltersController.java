package com.turkcellGyGy.filterservice.api.controller;


import com.turkcellGyGy.filterservice.business.abstracts.FilterService;
import com.turkcellGyGy.filterservice.business.dto.response.GetAllFilterResponse;
import com.turkcellGyGy.filterservice.business.dto.response.GetFilterResponse;
import com.turkcellGyGy.filterservice.entities.Filter;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/filters")
public class FiltersController {
    private final FilterService service;

    //bu direkt database e oluşturacak.
    @PostConstruct
    public void createDb()
    {

        System.out.println("PostConstructor Calisti");
        System.out.println("PostConstructor Calisti");
        System.out.println("PostConstructor Calisti");
        System.out.println("PostConstructor Calisti");
        System.out.println("PostConstructor Calisti");


        service.add(new Filter());

    }
    @GetMapping
    public List<GetAllFilterResponse> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetFilterResponse getById(@PathVariable UUID id){
        return service.getById(id);
    }


}
