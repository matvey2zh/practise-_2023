package com.mozhzhey.spring.mvc_hibernate_aop.service.loginHelper;

public class LoginHelper {

    private String name;

    private String surname;

    private String password;

    @Override
    public String toString() {
        return "LoginHelper{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public LoginHelper() {
    }

    public LoginHelper(String name, String surname, String password) {
        this.name = name;
        this.surname = surname;
        this.password = password;
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
}
