package com.mozhzhey.spring.mvc_hibernate_aop.entity;

import javax.persistence.*;

@Entity
@Table(name = "dispatchers")
public class Dispatchers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "password")
    private int password;

    @Column(name = "phone_number")
    private int phoneNumber;


    public Dispatchers() {
    }

    public Dispatchers(String name, String surname, int password, int phone_number) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.phoneNumber = phone_number;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phone_number) {
        this.phoneNumber = phone_number;
    }
}
