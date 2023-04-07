package com.example.rentacar.business.dto.responses.update.maintenances;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateMaintenancesResponse {
    private long id;
    private String description;
    private long carId;
    private boolean isCompleted;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

  }
