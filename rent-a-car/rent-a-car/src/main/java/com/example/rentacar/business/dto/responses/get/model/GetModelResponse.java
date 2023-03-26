package com.example.rentacar.business.dto.responses.get.model;

public class GetModelResponse {

    private long id;
    private String name;

    public GetModelResponse() {
    }

    public GetModelResponse(long id, String name) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
