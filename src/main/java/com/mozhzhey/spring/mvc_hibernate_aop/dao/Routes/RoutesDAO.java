package com.mozhzhey.spring.mvc_hibernate_aop.dao.Routes;

import com.mozhzhey.spring.mvc_hibernate_aop.entity.Routes;

import java.util.List;

public interface RoutesDAO {
    public  void saveRoute(Routes routes);

    public List<Routes> getAllRoutes();

    public void deleteRoute(int id);

    public Routes getRoutes(int id);
}


