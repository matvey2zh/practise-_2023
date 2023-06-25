package com.mozhzhey.spring.mvc_hibernate_aop.entity;

import java.util.Date;

public class OrderTMP {
    private String name;
    private String dispName;
    private Date dateOfDispatch;
    private Date dateOfAcceptance;

    public OrderTMP(String name, String dispName, Date dateOfDispatch, Date dateOfAcceptance) {
        this.name = name;
        this.dispName = dispName;
        this.dateOfDispatch = dateOfDispatch;
        this.dateOfAcceptance = dateOfAcceptance;
    }

    public OrderTMP() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDispName() {
        return dispName;
    }

    public void setDispName(String dispName) {
        this.dispName = dispName;
    }

    public Date getDateOfDispatch() {
        return dateOfDispatch;
    }

    public void setDateOfDispatch(Date dateOfDispatch) {
        this.dateOfDispatch = dateOfDispatch;
    }

    public Date getDateOfAcceptance() {
        return dateOfAcceptance;
    }

    public void setDateOfAcceptance(Date dateOfAcceptance) {
        this.dateOfAcceptance = dateOfAcceptance;
    }
}
