package com.example.rentacar.entity;


import jakarta.persistence.*;

@Entity
public class Maintenances {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //OneToOne relationsship we can use here?

    private String description;

    @OneToOne
    private Car car;


    public Maintenances() {
    }

    public Maintenances(long id, Car car,
                        String description) {
        this.id = id;
        this.car = car;
        this.description = description;
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

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

}
