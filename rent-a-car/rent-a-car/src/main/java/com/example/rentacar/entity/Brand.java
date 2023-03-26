package com.example.rentacar.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;



@Entity
@Table(name = "brands") //snake_case tutulur PostgreSQL
public class Brand {
    @Id //Primary Key -> PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //Brand zaten class ismi oldugu icin `name` olarak kullanabiliriz.
    @Column(name = "name")
    private String name;

    //olduğu yerdeki adına göre mapped et.
    @OneToMany(mappedBy = "brand")
    private List<Model> models;

    public Brand() {
    }
    public Brand(long id, String name, List<Model> models) {
        this.id = id;
        this.name = name;
        this.models = models;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }
}
