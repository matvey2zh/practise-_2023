package com.mozhzhey.spring.mvc_hibernate_aop.service.Cars;

import com.mozhzhey.spring.mvc_hibernate_aop.entity.Cars;

import java.util.List;

public interface CarService {
    public List<Cars> getAllCars();

    public void saveCar(Cars car);

    public Cars getCar(int id);
    public void deleteCar(int id);
}
