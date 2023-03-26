package com.example.rentacar.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "models")
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ManyToOne
    //brand_id modeldeki brand_id nin adı kısmı
    @JoinColumn(name = "brand_id")
    private Brand brand;


    @OneToMany(mappedBy = "model")
    private List<Car> cars;

    public Model() {
    }

    public Model(long id, String name) {
        this.id = id;
        this.name = name;
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
}
