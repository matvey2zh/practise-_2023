package com.mozhzhey.spring.mvc_hibernate_aop.service.Cars;

import com.mozhzhey.spring.mvc_hibernate_aop.dao.Cars.CarsDAO;
import com.mozhzhey.spring.mvc_hibernate_aop.entity.Cars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CarServiceImpl implements CarService{
    @Autowired
    private CarsDAO carsDAO;

    @Override
    @Transactional
    public List<Cars> getAllCars() {
        return carsDAO.getAllCars();
    }

    @Override
    @Transactional
    public void saveCar(Cars car) {
        carsDAO.saveCar(car);
    }

    @Override
    @Transactional
    public Cars getCar(int id) {
        return carsDAO.getCar(id);
    }
    @Override
    @Transactional
    public void deleteCar(int id){
        carsDAO.deleteCar(id);
    }
}
