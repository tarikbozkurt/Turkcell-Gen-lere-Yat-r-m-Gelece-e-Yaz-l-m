package com.example.rentacar.business.dto.requests.update.maintenances;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateMaintenancesRequest {


    private String description;
    private long carId;
    private boolean isCompleted;
    private LocalDateTime startDate;
    private LocalDateTime endDate;


}
