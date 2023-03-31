package com.example.ecommercesystem.service.dto.response.get.product;

import com.example.ecommercesystem.entity.Category;
import com.example.ecommercesystem.service.enums.Status;

import java.util.List;

public class GetProductResponse {


    private String name;
    private int quantity;
    private double unitPrice;
    private String description;

    private Status status;
    private List<Category> categories;

    public GetProductResponse() {
    }

    public GetProductResponse(String name, int quantity, double unitPrice, String description, Status status, List<Category> categories) {
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.description = description;
        this.status = status;
        this.categories = categories;
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

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
