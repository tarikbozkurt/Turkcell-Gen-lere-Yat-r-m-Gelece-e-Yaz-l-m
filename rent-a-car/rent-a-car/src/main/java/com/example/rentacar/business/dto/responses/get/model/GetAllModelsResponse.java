package com.example.rentacar.business.dto.responses.get.model;

public class GetAllModelsResponse {

    private long id;
    private String name;

    public GetAllModelsResponse() {
    }

    public GetAllModelsResponse(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
