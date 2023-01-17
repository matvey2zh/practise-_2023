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

    @Column(name = "work_experience")
    private int workExperience;

    @OneToOne
    @JoinColumn(name = "car_id")
    private Cars driverCar;





    public Drivers(String name, int workExperience) {
        this.name = name;
        this.workExperience = workExperience;
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
