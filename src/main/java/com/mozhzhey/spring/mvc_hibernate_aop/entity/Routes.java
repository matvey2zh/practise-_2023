package com.mozhzhey.spring.mvc_hibernate_aop.entity;


import javax.persistence.*;

@Entity
@Table(name = "routes")
public class Routes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "point_of_departure")
    private String pointOfDeparture;

    @Column(name = "point_of_delivery")
    private String pointOfDelivery;

    public Routes() {
    }

    public Routes(String pointOfDeparture, String pointOfDelivery) {
        this.pointOfDeparture = pointOfDeparture;
        this.pointOfDelivery = pointOfDelivery;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPointOfDeparture() {
        return pointOfDeparture;
    }

    public void setPointOfDeparture(String pointOfDeparture) {
        this.pointOfDeparture = pointOfDeparture;
    }

    public String getPointOfDelivery() {
        return pointOfDelivery;
    }

    public void setPointOfDelivery(String pointOfDelivery) {
        this.pointOfDelivery = pointOfDelivery;
    }
}
