package com.example.rentacar.entites;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "brands") //snake_case tutulur PostgreSQL
public class Brand {
    @Id //Primary Key -> PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //Brand zaten class ismi oldugu icin `name` olarak kullanabiliriz.
    @Column(name = "name")
    private String name;



}
