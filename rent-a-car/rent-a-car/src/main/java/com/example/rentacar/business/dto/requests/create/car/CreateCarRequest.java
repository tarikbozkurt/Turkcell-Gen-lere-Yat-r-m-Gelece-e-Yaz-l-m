package com.example.rentacar.business.dto.requests.create.car;

public class CreateCarRequest {

    private int modelYear;
    private String plate;
    private int state; // 1 - Available , 2 - Rented , 3 - Maintance
    private double dailyPrice;

    public CreateCarRequest() {
    }

    public CreateCarRequest(int modelYear, String plate, int state, double dailyPrice) {
        this.modelYear = modelYear;
        this.plate = plate;
        this.state = state;
        this.dailyPrice = dailyPrice;
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public double getDailyPrice() {
        return dailyPrice;
    }

    public void setDailyPrice(double dailyPrice) {
        this.dailyPrice = dailyPrice;
    }
}
