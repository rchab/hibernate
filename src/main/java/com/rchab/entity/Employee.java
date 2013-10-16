package com.rchab.entity;

public class Employee {
    private int id;
    private String firstName;
    private String secondName;
    private int salery;

    public Employee(String firstName, String secondName, int salery) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.salery = salery;
    }

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getSalery() {
        return salery;
    }

    public void setSalery(int salery) {
        this.salery = salery;
    }

    @Override
    public String toString() {
        return firstName + " " + secondName + ": salery " + salery;
    }
}
