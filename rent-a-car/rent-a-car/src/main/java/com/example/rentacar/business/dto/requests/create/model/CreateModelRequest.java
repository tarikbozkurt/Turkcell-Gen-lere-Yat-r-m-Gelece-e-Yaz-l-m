package com.example.rentacar.business.dto.requests.create.model;

public class CreateModelRequest {

    private String name;

    public CreateModelRequest() {
    }

    public CreateModelRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
