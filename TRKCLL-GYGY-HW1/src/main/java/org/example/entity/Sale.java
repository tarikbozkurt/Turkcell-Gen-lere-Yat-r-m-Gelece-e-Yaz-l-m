package org.example.entity;

import org.example.entity.BaseEntity.BaseEntity;

public class Sale extends BaseEntity<Integer> {

    //We will sale for a player so we should save the player...
    private Player isFor;

    private double amount;

    public Sale(Integer id, Player isFor, double amount) {
        super(id);
        this.isFor = isFor;
        this.amount = amount;
    }


    public Player getIsFor() {
        return isFor;
    }

    public void setIsFor(Player isFor) {
        this.isFor = isFor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "isFor=" + isFor +
                ", amount=" + amount +
                '}';
    }
}
