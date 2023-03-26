package com.example.rentacar.business.dto.responses.update.brand;

public class UpdateBrandResponse {

    private String name;

    public UpdateBrandResponse(String name) {
        this.name = name;
    }

    public UpdateBrandResponse() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

