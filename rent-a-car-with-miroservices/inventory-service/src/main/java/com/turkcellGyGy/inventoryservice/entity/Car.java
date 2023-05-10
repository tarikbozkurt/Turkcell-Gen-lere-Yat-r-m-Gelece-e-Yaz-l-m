package com.turkcellGyGy.inventoryservice.entity;


import com.turkcellGyGy.inventoryservice.entity.enums.State;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="cars")
@AllArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private int modelYear;
    private String plate;
    @Enumerated(EnumType.STRING)
    private State state;
    private double dailyPrice;

    @ManyToOne()
    @JoinColumn(name="model_id")
    private Model model;


}
