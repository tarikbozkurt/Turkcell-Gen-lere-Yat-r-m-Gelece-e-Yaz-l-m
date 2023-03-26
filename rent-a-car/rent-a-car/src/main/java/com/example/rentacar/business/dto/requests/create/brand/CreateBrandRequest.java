package com.example.rentacar.business.dto.requests.create.brand;



public class CreateBrandRequest {

    private String name;

    public CreateBrandRequest(String name) {
        this.name = name;
    }

    public CreateBrandRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
