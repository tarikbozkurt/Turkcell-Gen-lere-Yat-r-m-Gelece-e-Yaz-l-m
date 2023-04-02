package com.example.rentacar.business.dto.requests.update.brand;

public class UpdateBrandRequest {



    private long id;
    private String name;



    public UpdateBrandRequest() {
    }
    public UpdateBrandRequest(long id, String name) {
        this.id = id;
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
