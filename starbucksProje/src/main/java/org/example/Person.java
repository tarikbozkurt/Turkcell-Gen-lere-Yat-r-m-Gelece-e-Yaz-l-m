package org.example;

public class Person {

    private String name;
    private String lastName;
    private int birthYear;
    private String nationalId;


    public Person() {
    }

    public Person(String name, String lastName, int birthYear, String nationalId) {
        this.name = name;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.nationalId = nationalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }
}
