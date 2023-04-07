package com.example.rentacar.business.dto.requests.update.car;

import com.example.rentacar.entity.enumerations.State;

public class UpdateCarRequest {

    private int modelYear;
    private String plate;
    private State state; // 1 - Available , 2 - Rented , 3 - Maintance
    private double dailyPrice;

    private int modelId;



    public UpdateCarRequest() {
    }

    public UpdateCarRequest(int modelYear, String plate, State state, double dailyPrice,int modelId) {
        this.modelYear = modelYear;
        this.plate = plate;
        this.state = state;
        this.dailyPrice = dailyPrice;
        this.modelId = modelId;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public double getDailyPrice() {
        return dailyPrice;
    }

    public void setDailyPrice(double dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }
}
