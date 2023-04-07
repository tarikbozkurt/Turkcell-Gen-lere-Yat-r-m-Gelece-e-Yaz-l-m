package com.example.rentacar.api.controllers;


import com.example.rentacar.business.abstracts.MaintenancesService;
import com.example.rentacar.business.dto.requests.create.maintenances.CreateMaintenancesRequest;
import com.example.rentacar.business.dto.requests.update.maintenances.UpdateMaintenancesRequest;
import com.example.rentacar.business.dto.responses.create.maintenances.CreateMaintenancesResponse;
import com.example.rentacar.business.dto.responses.get.maintenances.GetAllMaintenancesResponse;
import com.example.rentacar.business.dto.responses.get.maintenances.GetMaintenancesResponse;
import com.example.rentacar.business.dto.responses.update.maintenances.UpdateMaintenancesResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/maintenances")
public class MaintenancesController {

    public MaintenancesController(MaintenancesService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    private final MaintenancesService maintenanceService;


    @GetMapping
    public List<GetAllMaintenancesResponse> getAll() {
        return maintenanceService.getAll();
    }

    @GetMapping("/{id}")
    public GetMaintenancesResponse getById(@PathVariable int id) {
        return maintenanceService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateMaintenancesResponse add(@RequestBody CreateMaintenancesRequest request) {
        return maintenanceService.add(request);
    }

    @PutMapping("/return/{carId}")
    public GetMaintenancesResponse returnCarFromMaintenance(@PathVariable int carId) {
        return maintenanceService.returnCarFromMaintenance(carId);
    }
    @PutMapping("/{id}")
    public UpdateMaintenancesResponse update(@PathVariable int id, @RequestBody UpdateMaintenancesRequest request) {
        return maintenanceService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        maintenanceService.delete(id);
    }


}
