package com.example.rentacar.business.dto.requests.create.brand;



public class CreateBrandRequest {

    private long id;
    private String name;

    public CreateBrandRequest() {
    }

    public CreateBrandRequest(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
