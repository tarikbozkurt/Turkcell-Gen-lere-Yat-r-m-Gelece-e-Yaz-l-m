package com.example.rentacar.business.dto.responses.get.maintenances;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetMaintenancesResponse {

    private long id;
    private String description;
    private long carId;
    private boolean isCompleted;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

}
