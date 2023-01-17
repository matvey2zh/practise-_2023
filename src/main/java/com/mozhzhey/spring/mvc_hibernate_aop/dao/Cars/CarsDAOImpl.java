package com.mozhzhey.spring.mvc_hibernate_aop.dao.Cars;

import com.mozhzhey.spring.mvc_hibernate_aop.entity.Cars;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.management.Query;
import java.util.List;

@Repository
public class CarsDAOImpl implements CarsDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Cars> getAllCars() {

        Session session = sessionFactory.getCurrentSession();
        List<Cars> carsList = session.createQuery("from Cars",
                        Cars.class)
                .getResultList();
        return carsList;
    }

    @Override
    public void saveCar(Cars car) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(car);
    }

    @Override
    public Cars getCar(int id) {
        Session session = sessionFactory.getCurrentSession();

        Cars car = session.get(Cars.class, id);

        return car;
    }

    @Override
    public void deleteCar(int id) {
        Session session = sessionFactory.getCurrentSession();
        Cars car = session.get(Cars.class,id);
        session.delete(car);
    }
}
