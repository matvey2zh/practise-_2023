package com.mozhzhey.spring.mvc_hibernate_aop.dao.Drivers;

import com.mozhzhey.spring.mvc_hibernate_aop.entity.Drivers;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface DriversDao {
    public List<Drivers> getAllDrivers();

    public void saveDriver(Drivers driver);

    public void deleteDriver(int id);
}
