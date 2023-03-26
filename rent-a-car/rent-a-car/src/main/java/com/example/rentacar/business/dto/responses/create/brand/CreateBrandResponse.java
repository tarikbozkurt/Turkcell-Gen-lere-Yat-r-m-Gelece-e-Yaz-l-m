package com.example.rentacar.business.dto.responses.create.brand;

public class CreateBrandResponse {

    private long id;
    private String name;

    public CreateBrandResponse() {
    }

    public CreateBrandResponse(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
