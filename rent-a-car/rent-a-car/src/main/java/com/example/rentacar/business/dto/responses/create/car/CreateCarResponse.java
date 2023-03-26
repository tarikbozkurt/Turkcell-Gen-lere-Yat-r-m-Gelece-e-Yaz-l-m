package com.example.rentacar.business.dto.responses.create.car;

public class CreateCarResponse {

    private long id;
    private int modelYear;
    private String plate;
    private int state; // 1 - Available , 2 - Rented , 3 - Maintance
    private double dailyPrice;

    public CreateCarResponse() {
    }

    public CreateCarResponse(long id, int modelYear, String plate, int state, double dailyPrice) {
        this.id = id;
        this.modelYear = modelYear;
        this.plate = plate;
        this.state = state;
        this.dailyPrice = dailyPrice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
