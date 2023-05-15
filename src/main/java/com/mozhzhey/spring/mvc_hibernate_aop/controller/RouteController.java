package com.mozhzhey.spring.mvc_hibernate_aop.controller;

import com.mozhzhey.spring.mvc_hibernate_aop.entity.Routes;
import com.mozhzhey.spring.mvc_hibernate_aop.service.Routes.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller()
public class RouteController {
    @Autowired
    private RouteService routeService;

    @RequestMapping("/routes")
    public String showAllRoutes(Model model) {
        List<Routes> routesList = routeService.getAllRoutes();
        model.addAttribute("routes", routesList);

        Routes routes =  new Routes();
        model.addAttribute("route", routes);

        return "allRoutes";
    }







    @RequestMapping("/saveRoute")
    public String saveRoute(@ModelAttribute("route") Routes routes) {
        routeService.saveRoute(routes);
        return "redirect:/routes";
    }

    @RequestMapping("/updateRoute")
    public String updateRoute(@RequestParam("routeId") int id, Model model) {
        Routes route = routeService.getRoutes(id);
        model.addAttribute("route", route);
        return "route-info";
    }

    @RequestMapping("/deleteRoute")
    public String deleteRoute(@RequestParam("routeId") int id) {

        routeService.deleteRoute(id);
        return "redirect:/routes";
    }

}
