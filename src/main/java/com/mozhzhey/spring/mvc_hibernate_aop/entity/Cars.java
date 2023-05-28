package com.mozhzhey.spring.mvc_hibernate_aop.entity;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Cars implements Comparable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "year_of_release")
    private int yearOfRelease;

    @Column(name = "model")
    private String model;

    @Column(name = "goverment_number")
    private String govermentNumber;

    public String getGovermentNumber() {
        return govermentNumber;
    }

    public void setGovermentNumber(String govermentNumber) {
        this.govermentNumber = govermentNumber;
    }

    public Cars() {
    }

    public Cars(String brand, int yearOfRelease, String model, String govermentNumber) {
        this.brand = brand;
        this.yearOfRelease = yearOfRelease;
        this.model = model;
        this.govermentNumber = govermentNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    @Override
    public String toString() {
        return "Cars{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                ", model='" + model + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
