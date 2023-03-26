package com.example.rentacar.business.dto.responses.get.car;

public class GetAllCarsResponse {

    private long id;
    private int modelYear;
    private String plate;
    private int state; // 1 - Available , 2 - Rented , 3 - Maintance
    private double dailyPrice;

    public GetAllCarsResponse() {
    }

    public GetAllCarsResponse(long id, int modelYear, String plate, int state, double dailyPrice) {
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

    public int getState() {
        return state;
    }

    public double getDailyPrice() {
        return dailyPrice;
    }


}
