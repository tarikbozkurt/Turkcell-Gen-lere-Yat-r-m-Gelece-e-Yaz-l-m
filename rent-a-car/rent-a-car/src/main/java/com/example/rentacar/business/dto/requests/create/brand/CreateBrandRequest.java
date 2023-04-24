package com.example.rentacar.business.dto.requests.create.brand;


import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class CreateBrandRequest {


    @NotBlank
    @Length(min = 2, max=50)
    private String name;

    public CreateBrandRequest() {
    }

    public CreateBrandRequest(long id, String name) {

        this.name = name;
    }

      public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
