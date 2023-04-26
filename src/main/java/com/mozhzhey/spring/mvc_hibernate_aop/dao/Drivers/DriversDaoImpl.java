package com.mozhzhey.spring.mvc_hibernate_aop.dao.Drivers;

import com.mozhzhey.spring.mvc_hibernate_aop.entity.Cars;
import com.mozhzhey.spring.mvc_hibernate_aop.entity.Dispatchers;
import com.mozhzhey.spring.mvc_hibernate_aop.entity.Drivers;
import com.mozhzhey.spring.mvc_hibernate_aop.entity.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public class DriversDaoImpl implements DriversDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Drivers> getAllDrivers() {

        Session session = sessionFactory.getCurrentSession();
        List<Drivers> driversList = session.createQuery("from Drivers",
                        Drivers.class)
                .getResultList();
        return driversList;
    }

    @Override
    public void saveDriver(Drivers driver) {
        Session session = sessionFactory.getCurrentSession();
        session.save(driver);
    }

    @Override
    public void deleteDriver(int id) {
        Session session = sessionFactory.getCurrentSession();
        Drivers driver = session.get(Drivers.class,id);
        session.delete(driver);
    }

    @Override
    public Drivers getDriver(int id) {
        Session session = sessionFactory.getCurrentSession();

        Drivers drivers = session.get(Drivers.class, id);

        return drivers;
    }
}
