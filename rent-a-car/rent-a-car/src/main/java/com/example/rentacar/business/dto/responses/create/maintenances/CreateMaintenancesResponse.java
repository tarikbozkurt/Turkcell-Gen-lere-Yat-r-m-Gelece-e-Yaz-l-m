package com.example.rentacar.business.dto.responses.create.maintenances;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateMaintenancesResponse {

    private long id;
    private int carId;
    private String description;
    private boolean isCompleted;
    private LocalDateTime startDate;
    private LocalDateTime endDate;


}
