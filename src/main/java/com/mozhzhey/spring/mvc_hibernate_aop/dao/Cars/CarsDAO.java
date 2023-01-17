package com.mozhzhey.spring.mvc_hibernate_aop.dao.Cars;

import com.mozhzhey.spring.mvc_hibernate_aop.entity.Cars;

import java.util.List;

public interface CarsDAO {
    public List<Cars> getAllCars();

    public void saveCar(Cars car);

    public Cars getCar(int id);

    public void deleteCar(int id);
}
