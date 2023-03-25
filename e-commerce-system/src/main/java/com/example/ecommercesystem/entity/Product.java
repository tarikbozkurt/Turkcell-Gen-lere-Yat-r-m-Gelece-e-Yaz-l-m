package com.example.ecommercesystem.entity;


import jakarta.persistence.*;

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

    public Product() { //No args constructor
    }

    public Product(long id, String name, int quantity, double price, String description) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = price;
        this.description = description;
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
}
