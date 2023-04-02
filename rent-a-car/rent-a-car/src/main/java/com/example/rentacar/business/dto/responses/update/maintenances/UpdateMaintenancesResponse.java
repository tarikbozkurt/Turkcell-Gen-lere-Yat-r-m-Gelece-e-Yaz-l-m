package com.example.rentacar.business.dto.responses.update.maintenances;

public class UpdateMaintenancesResponse {
    private long id;
    private String description;
    private long carId;

    public UpdateMaintenancesResponse() {
    }

    public UpdateMaintenancesResponse(long id, String description, long carId) {
        this.id = id;
        this.description = description;
        this.carId = carId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
