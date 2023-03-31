package com.example.ecommercesystem.entity;


import com.example.ecommercesystem.service.enums.Status;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products") //snake_case tutulur PostgreSQL
//WE CAN USE LOMBOK FOR ALLARGSCONSTRUCTOR, NOARGSCONSTRUCTOR AND GETTER/SETTER
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int quantity;
    private double unitPrice;
    private String description;

    //EAGER, LAZY, İsstenildiğinde veri getirilecekse LAZY kullanılıyoruz.
    @JsonManagedReference()
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Category> categories = new HashSet<>();;


    @Enumerated(EnumType.STRING)
    private Status status;

    public Product() { //No args constructor
    }

    public Product(long id, String name, int quantity, double price, String description,Status status) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = price;
        this.description = description;
        this.status = status;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
