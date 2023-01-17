package com.mozhzhey.spring.mvc_hibernate_aop.service.Routes;

import com.mozhzhey.spring.mvc_hibernate_aop.entity.Routes;

import java.util.List;

public interface RouteService {
    public List<Routes> getAllRoutes();

    public void saveRoute(Routes routes);

    public void deleteRoute(int id);

    public Routes getRoutes(int id);
}
