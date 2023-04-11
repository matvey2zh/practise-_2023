package com.mozhzhey.spring.mvc_hibernate_aop.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "order_name")
    private String name;

    @Column(name = "date_of_dispatch")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfDispatch;

    @Column(name = "date_of_acceptance")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfAcceptance;

    @Column(name = "order_condition")
    private String orderCondition;

    @OneToOne
    @JoinColumn(name = "dispatcher_id")
    private Dispatchers dispatcher;

    @OneToOne
    @JoinColumn(name = "driver_id")
    private Drivers driver;

    @OneToOne
    @JoinColumn(name = "adress_departure_id")
    private Routes departureAdress;

    public Routes getDepartureAdress() {
        return departureAdress;
    }

    public void setDepartureAdress(Routes departureAdress) {
        this.departureAdress = departureAdress;
    }

    public Routes getDeliveryAdress() {
        return deliveryAdress;
    }

    public void setDeliveryAdress(Routes deliveryAdress) {
        this.deliveryAdress = deliveryAdress;
    }

    @OneToOne
    @JoinColumn(name = "adress_delivery_id")
    private Routes deliveryAdress;

    public Orders(String name, Date dateOfDispatch, Date dateOfAcceptance, String orderCondition) {
        this.name = name;
        this.dateOfDispatch = dateOfDispatch;
        this.dateOfAcceptance = dateOfAcceptance;
        this.orderCondition = orderCondition;
    }

    public Orders() {
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

    public String getOrderCondition() {
        return orderCondition;
    }

    public void setOrderCondition(String orderCondition) {
        this.orderCondition = orderCondition;
    }

    public Dispatchers getDispatcher() {
        return dispatcher;
    }

    public void setDispatcher(Dispatchers dispatcher) {
        this.dispatcher = dispatcher;
    }

    public Drivers getDriver() {
        return driver;
    }

    public void setDriver(Drivers driver) {
        this.driver = driver;
    }


}
