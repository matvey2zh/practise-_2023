package com.mozhzhey.spring.mvc_hibernate_aop.service.Routes;

import com.mozhzhey.spring.mvc_hibernate_aop.dao.Routes.RoutesDAO;
import com.mozhzhey.spring.mvc_hibernate_aop.entity.Routes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RouteServiceImpl implements RouteService{

    @Autowired
    private RoutesDAO routesDAO;

    @Override
    @Transactional
    public List<Routes> getAllRoutes() {
        return routesDAO.getAllRoutes();
    }

    @Override
    @Transactional
    public void saveRoute(Routes routes) {
        routesDAO.saveRoute(routes);
    }

    @Override
    @Transactional
    public void deleteRoute(int id) {
        routesDAO.deleteRoute(id);
    }

    @Override
    @Transactional
    public Routes getRoutes(int id) {
        return routesDAO.getRoutes(id);
    }
}
