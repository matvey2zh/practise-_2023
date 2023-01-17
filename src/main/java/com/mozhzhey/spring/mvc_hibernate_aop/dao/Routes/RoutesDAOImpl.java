package com.mozhzhey.spring.mvc_hibernate_aop.dao.Routes;

import com.mozhzhey.spring.mvc_hibernate_aop.entity.Cars;
import com.mozhzhey.spring.mvc_hibernate_aop.entity.Orders;
import com.mozhzhey.spring.mvc_hibernate_aop.entity.Routes;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoutesDAOImpl implements RoutesDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveRoute(Routes routes) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(routes);
    }

    @Override
    public List<Routes> getAllRoutes() {

        Session session = sessionFactory.getCurrentSession();
        List<Routes> routesList = session.createQuery("from Routes",
                        Routes.class)
                .getResultList();
        return routesList;
    }

    @Override
    public void deleteRoute(int id) {
        Session session = sessionFactory.getCurrentSession();
        Routes route = session.get(Routes.class,id);
        session.delete(route);
    }

    @Override
    public Routes getRoutes(int id) {
        Session session = sessionFactory.getCurrentSession();

        Routes route = session.get(Routes.class, id);

        return route;
    }
}
