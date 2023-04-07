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

import java.time.LocalDateTime;
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
        Maintenances maintenances = maintenanceRepository.findById(id).orElseThrow();
        GetMaintenancesResponse response = mapper.map(maintenances,GetMaintenancesResponse.class);

        return response;
    }

    @Override
    public GetMaintenancesResponse returnCarFromMaintenance(long carId) {
        checkIfCarIsNotUnderMaintenance(carId);
        Maintenances maintenances = maintenanceRepository.findByCarIdAndIsCompletedIsFalse(carId);
        maintenances.setCompleted(true);
        maintenances.setEndDate(LocalDateTime.now());
        maintenanceRepository.save(maintenances); // updated
        carService.changeState(carId,State.AVAILABLE);

        GetMaintenancesResponse response = mapper.map(maintenances,GetMaintenancesResponse.class);
        return response;
    }

    @Override
    public CreateMaintenancesResponse add(CreateMaintenancesRequest request) {
        checkIfCarIsUnderMaintenance(request);
        checkCarAvailabilityForMaintenance(request);
        Maintenances maintenances = mapper.map(request, Maintenances.class);
        maintenances.setId(0);
        maintenances.setCompleted(false);
        maintenances.setStartDate(LocalDateTime.now());
        maintenances.setEndDate(null);
        maintenanceRepository.save(maintenances);
        carService.changeState(request.getCarId(), State.MAINTENANCE);
        CreateMaintenancesResponse response = mapper.map(maintenances, CreateMaintenancesResponse.class);

        return response;
    }

    @Override
    public UpdateMaintenancesResponse update(long id, UpdateMaintenancesRequest request) {
        checkIfMaintenanceExistsById(id);
        Maintenances maintenances = mapper.map(request,Maintenances.class);

        maintenances.setId(id);
        maintenanceRepository.save(maintenances);

        UpdateMaintenancesResponse response = mapper.map(maintenances,UpdateMaintenancesResponse.class);


        return response;
    }

    @Override
    public void delete(long id) {

        checkIfMaintenanceExistsById(id);
        maintenanceRepository.deleteById(id);
    }

    private void checkIfMaintenanceExistsById(long id) {
        if (!maintenanceRepository.existsById(id)) {
            throw new RuntimeException("Maintenance does not exists with id: " + id);
        }
    }


    private void  checkIfCarIsNotUnderMaintenance(long carId) {
        if(!maintenanceRepository.existsByCarIdAndIsCompletedIsFalse(carId)){
            throw new RuntimeException("There is not a car in Maintenance List !!");
        }

    }

    private void  checkIfCarIsUnderMaintenance(CreateMaintenancesRequest request) {
        if (maintenanceRepository.existsByCarIdAndIsCompletedIsFalse(request.getCarId())) {
            throw new RuntimeException("Araç bakımda !!");
        }

    }
    private void checkCarAvailabilityForMaintenance(CreateMaintenancesRequest request) {
        if (carService.getById(request.getCarId()).getState().equals(State.RENTED)) {
            throw new RuntimeException("Araç kirada olduğu için bakıma alınamaz!");
        }
    }

    /*
    private void changeExitingCarState(long id) {
        Maintenances maintenance = maintenanceRepository.findById(id).orElseThrow();
        maintenance.getCar().setState(State.AVAILABLE);
    } */


}
