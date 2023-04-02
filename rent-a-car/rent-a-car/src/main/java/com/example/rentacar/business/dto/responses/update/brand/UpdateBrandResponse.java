package com.example.rentacar.business.dto.responses.update.brand;

public class UpdateBrandResponse {



    private long id;
    private String name;

    public UpdateBrandResponse(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public UpdateBrandResponse() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

