package com.example.rentacar.business.dto.responses.get.car;

import com.example.rentacar.entity.enumerations.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCarsResponse {

    private long id;
    private int modelYear;
    private String plate;
    private State state; // 1 - Available , 2 - Rented , 3 - Maintance
    private double dailyPrice;

    private String modelId;



}
