package com.example.rentacar.business.dto.requests.create.maintenances;

import com.example.rentacar.entity.Car;
import jakarta.persistence.OneToOne;

public class CreateMaintenancesRequest {

    private String description;
    private long carId;

    public CreateMaintenancesRequest() {
    }

    public CreateMaintenancesRequest(String description, long carId) {
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
