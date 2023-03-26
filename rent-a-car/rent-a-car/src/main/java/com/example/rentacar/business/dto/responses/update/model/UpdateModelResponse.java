package com.example.rentacar.business.dto.responses.update.model;

public class UpdateModelResponse {


    private String name;

    public UpdateModelResponse() {
    }

    public UpdateModelResponse(String name) {

        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
