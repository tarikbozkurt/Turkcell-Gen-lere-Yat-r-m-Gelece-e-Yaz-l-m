package org.example.entity;

import org.example.entity.BaseEntity.BaseEntity;

import java.util.Date;

public class Player  extends BaseEntity<Integer> {


    private String identityNumber;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String nickName;
    private double amount;

    public Player(Integer id, String identityNumber, String firstName, String lastName, Date birthDate, String nickName, double amount) {
        super(id);
        this.identityNumber = identityNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.nickName = nickName;
        this.amount = amount;
    }


    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Player{" +
                "identityNumber='" + identityNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", nickName='" + nickName + '\'' +
                ", amount=" + amount +
                '}';
    }
}
