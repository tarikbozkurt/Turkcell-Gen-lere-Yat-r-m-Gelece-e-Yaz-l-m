package com.example.rentacar.business.dto.requests.update.maintenances;

public class UpdateMaintenancesRequest {


    private String description;
    private long carId;

    public UpdateMaintenancesRequest() {
    }

    public UpdateMaintenancesRequest(String description, long carId) {
        this.description = description;
        this.carId = carId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }
}
