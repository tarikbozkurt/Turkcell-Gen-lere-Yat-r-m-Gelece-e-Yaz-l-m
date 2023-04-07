package com.example.rentacar.entity;


import com.example.rentacar.entity.enumerations.State;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int modelYear;
    private String plate;


    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private State state; // 1 - Available , 2 - Rented , 3 - Maintance
    private double dailyPrice;


    @OneToMany(mappedBy = "car")
    private List<Maintenances> maintenances;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    public Car() {
    }

    public Car(long id, int modelYear, String plate, State state, double dailyPrice,List<Maintenances> maintenances ) {
        this.id = id;
        this.modelYear = modelYear;
        this.plate = plate;
        this.state = state;
        this.dailyPrice = dailyPrice;
        this.maintenances = maintenances;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public double getDailyPrice() {
        return dailyPrice;
    }

    public void setDailyPrice(double dailyPrice) {
        this.dailyPrice = dailyPrice;
    }
    public List<Maintenances> getMaintenances() {
        return maintenances;
    }

    public void setMaintenances(List<Maintenances> maintenances) {
        this.maintenances = maintenances;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }


}
