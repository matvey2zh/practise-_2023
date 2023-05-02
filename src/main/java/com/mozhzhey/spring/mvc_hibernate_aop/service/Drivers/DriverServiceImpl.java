package com.mozhzhey.spring.mvc_hibernate_aop.service.Drivers;

import com.mozhzhey.spring.mvc_hibernate_aop.dao.Drivers.DriversDao;
import com.mozhzhey.spring.mvc_hibernate_aop.entity.Drivers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DriverServiceImpl implements DriverService{

    @Autowired
    private DriversDao driversDao;

    @Override
    @Transactional
    public List<Drivers> getAllDrivers() {
        return driversDao.getAllDrivers();
    }

    @Override
    @Transactional
    public void saveDriver(Drivers driver) {
        driversDao.saveDriver(driver);
    }

    @Override
    @Transactional
    public void updateDriver(Drivers driver) {
        driversDao.updateDriver(driver);
    }

    @Override
    @Transactional
    public void deleteDriver(int id) {
        driversDao.deleteDriver(id);
    }

    @Override
    @Transactional
    public Drivers getDriver(int id) {
        return driversDao.getDriver(id);
    }
}
