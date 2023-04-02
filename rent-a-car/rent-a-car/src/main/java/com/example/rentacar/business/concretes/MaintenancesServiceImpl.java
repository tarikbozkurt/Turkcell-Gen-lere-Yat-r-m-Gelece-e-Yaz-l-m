package com.example.rentacar.business.concretes;

import com.example.rentacar.business.abstracts.CarService;
import com.example.rentacar.business.abstracts.MaintenancesService;
import com.example.rentacar.business.dto.requests.create.maintenances.CreateMaintenancesRequest;
import com.example.rentacar.business.dto.requests.update.maintenances.UpdateMaintenancesRequest;
import com.example.rentacar.business.dto.responses.create.maintenances.CreateMaintenancesResponse;
import com.example.rentacar.business.dto.responses.get.maintenances.GetAllMaintenancesResponse;
import com.example.rentacar.business.dto.responses.get.maintenances.GetMaintenancesResponse;
import com.example.rentacar.business.dto.responses.update.maintenances.UpdateMaintenancesResponse;
import com.example.rentacar.entity.Car;
import com.example.rentacar.entity.Maintenances;
import com.example.rentacar.entity.enumerations.State;
import com.example.rentacar.repository.MaintenancesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MaintenancesServiceImpl implements MaintenancesService {

    private final MaintenancesRepository maintenanceRepository;
    private final CarService carService;
    private final ModelMapper mapper;

    public MaintenancesServiceImpl(MaintenancesRepository maintenanceRepository, CarService carService, ModelMapper mapper) {
        this.maintenanceRepository = maintenanceRepository;
        this.carService = carService;
        this.mapper = mapper;
    }


    @Override
    public List<GetAllMaintenancesResponse> getAll() {
        List<Maintenances> maintenanceList = maintenanceRepository.findAll();

        List<GetAllMaintenancesResponse> response = maintenanceList
                .stream()
                .map(maintenance -> mapper.map(maintenance, GetAllMaintenancesResponse.class))
                .toList();

        return response;
    }

    @Override
    public GetMaintenancesResponse getById(long id) {
        checkIfMaintenanceExistsById(id);
        Maintenances maintenance = maintenanceRepository.findById(id).orElseThrow();

        GetMaintenancesResponse response = mapper.map(maintenance, GetMaintenancesResponse.class);
        return response;
    }

    @Override
    public CreateMaintenancesResponse add(CreateMaintenancesRequest request) {
        checkIfCarState(request.getCarId());

        Maintenances maintenance = mapper.map(request, Maintenances.class);
        maintenance.setId(0);
        Maintenances createdMaintenance = maintenanceRepository.save(maintenance);

        CreateMaintenancesResponse response = mapper.map(createdMaintenance, CreateMaintenancesResponse.class);
        return response;
    }

    @Override
    public UpdateMaintenancesResponse update(long id, UpdateMaintenancesRequest request) {
        return null;
    }

    @Override
    public void delete(long id) {
        checkIfMaintenanceExistsById(id);
        changeExitingCarState(id);
        maintenanceRepository.deleteById(id);
    }

    private void checkIfMaintenanceExistsById(long id) {
        if (!maintenanceRepository.existsById(id)) {
            throw new RuntimeException("Maintenance does not exists with id: " + id);
        }
    }

    private void changeExitingCarState(long id) {
        Maintenances maintenance = maintenanceRepository.findById(id).orElseThrow();
        maintenance.getCar().setState(State.AVAILABLE);
    }

    private void checkIfCarState(long carId) {
        Car car = carService.findCarById(carId);
        if(!(car.getState().toString() == "AVAILABLE")) {
            throw new RuntimeException("Car is not available");
        }
        car.setState(State.MAINTENANCE);
    }

}
