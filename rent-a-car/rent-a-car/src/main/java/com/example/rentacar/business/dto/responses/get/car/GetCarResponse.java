package com.example.rentacar.business.dto.responses.get.car;

import com.example.rentacar.entity.enumerations.State;

public class GetCarResponse {
    private long id;
    private int modelYear;
    private String plate;
    private State state; // 1 - Available , 2 - Rented , 3 - Maintance
    private double dailyPrice;

    public GetCarResponse() {
    }

    public GetCarResponse(long id, int modelYear, String plate, State state, double dailyPrice) {
        this.id = id;
        this.modelYear = modelYear;
        this.plate = plate;
        this.state = state;
        this.dailyPrice = dailyPrice;
    }

    public long getId() {
        return id;
    }

    public int getModelYear() {
        return modelYear;
    }

    public String getPlate() {
        return plate;
    }

    public State getState() {
        return state;
    }

    public double getDailyPrice() {
        return dailyPrice;
    }

}
