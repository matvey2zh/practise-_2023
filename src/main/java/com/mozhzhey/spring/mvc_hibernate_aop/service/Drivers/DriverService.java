package com.mozhzhey.spring.mvc_hibernate_aop.service.Drivers;

import com.mozhzhey.spring.mvc_hibernate_aop.entity.Drivers;

import java.util.List;

public interface DriverService {

    public List<Drivers> getAllDrivers();

    public void saveDriver(Drivers driver);

    void updateDriver(Drivers driver);

    public void deleteDriver(int id);

    public Drivers getDriver(int id);
}
