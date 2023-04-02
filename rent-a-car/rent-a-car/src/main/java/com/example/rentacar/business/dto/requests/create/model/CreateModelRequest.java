package com.example.rentacar.business.dto.requests.create.model;

public class CreateModelRequest {

    private String name;
    private int brandId;
    public CreateModelRequest() {
    }

    public CreateModelRequest(String name, int brandId) {
        this.name = name;
        this.brandId = brandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }
}
