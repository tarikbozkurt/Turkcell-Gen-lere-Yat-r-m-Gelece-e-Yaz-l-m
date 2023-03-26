package com.example.rentacar.business.dto.requests.update.brand;

public class UpdateBrandRequest {

    private String name;

    public UpdateBrandRequest(String name) {
        this.name = name;
    }

    public UpdateBrandRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
