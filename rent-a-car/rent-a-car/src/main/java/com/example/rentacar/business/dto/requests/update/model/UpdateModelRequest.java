package com.example.rentacar.business.dto.requests.update.model;

public class UpdateModelRequest {

    private String name;

    public UpdateModelRequest() {
    }

    public UpdateModelRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
