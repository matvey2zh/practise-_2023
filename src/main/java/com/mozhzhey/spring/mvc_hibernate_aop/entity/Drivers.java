package com.mozhzhey.spring.mvc_hibernate_aop.entity;

import javax.persistence.*;

@Entity
@Table(name = "drivers")
public class Drivers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "service_number")
    private String serviceNumber;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getServiceNumber() {
        return serviceNumber;
    }

    public void setServiceNumber(String serviceNumber) {
        this.serviceNumber = serviceNumber;
    }

    @Column(name = "work_experience")
    private int workExperience;

    @OneToOne
    @JoinColumn(name = "car_id")
    private Cars driverCar;


    public Drivers(int id, String name, String surname, String lastname, String serviceNumber, int workExperience, Cars driverCar) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.lastname = lastname;
        this.serviceNumber = serviceNumber;
        this.workExperience = workExperience;
        this.driverCar = driverCar;
    }

    public Drivers() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    public Cars getDriverCar() {
        return driverCar;
    }

    public void setDriverCar(Cars driverCar) {
        this.driverCar = driverCar;
    }
}
