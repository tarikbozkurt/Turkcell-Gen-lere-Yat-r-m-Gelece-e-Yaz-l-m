package com.example.rentacar.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Maintenances {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //OneToOne relationsship we can use here? we used ManyToOne

    private String description;
    private String information;
    private boolean isCompleted;
    private LocalDateTime startDate;
    private LocalDateTime endDate;


    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;



}
