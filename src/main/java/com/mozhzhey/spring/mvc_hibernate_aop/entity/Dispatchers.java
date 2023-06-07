package com.mozhzhey.spring.mvc_hibernate_aop.entity;

import javax.persistence.*;

@Entity
@Table(name = "dispatchers")
public class Dispatchers implements Comparable<Dispatchers> {

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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Column(name = "password")
    private String password;

    @Column(name = "phone_number")
    private int phoneNumber;


    public Dispatchers() {
    }

    public Dispatchers(int id, String name, String surname, String lastname, String password, int phoneNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.lastname = lastname;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Dispatchers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }

    @Override
    public int compareTo(Dispatchers anotherDispatcher) {
        return this.name.compareTo(anotherDispatcher.name);
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phone_number) {
        this.phoneNumber = phone_number;
    }
}
