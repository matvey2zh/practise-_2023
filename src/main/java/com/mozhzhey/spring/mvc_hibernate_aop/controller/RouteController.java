package com.mozhzhey.spring.mvc_hibernate_aop.controller;

import com.mozhzhey.spring.mvc_hibernate_aop.entity.Cars;
import com.mozhzhey.spring.mvc_hibernate_aop.entity.Dispatchers;
import com.mozhzhey.spring.mvc_hibernate_aop.entity.Routes;
import com.mozhzhey.spring.mvc_hibernate_aop.service.Routes.RouteService;
import com.mozhzhey.spring.mvc_hibernate_aop.service.SearchHelper.SearchHelper;
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

        refreshAttributes(model);


        return "allRoutes";
    }

    void refreshAttributes(Model model){
        SearchHelper searchHelper= new SearchHelper(new String());
        model.addAttribute("searchInfo",searchHelper);
        Routes route = new Routes();
        model.addAttribute("route", route);
    }
    @RequestMapping("/searchInfoInRoutes")
    public String searchInfoInRoutes(Model model,@ModelAttribute("searchInfo") SearchHelper info) {
        List<Routes> routesList = routeService.getAllRoutes();
        for (int j = 0; j < routesList.size(); j++) {
            for (int i = 0; i < routesList.size(); i++) {
                if (!routesList.get(i).getAdress().toLowerCase().contains(info.getInfo().toLowerCase())) {
                    routesList.remove(i);
                }

            }
        }

        model.addAttribute("routes", routesList);
        refreshAttributes(model);
        return "allRoutes";

    }

    @RequestMapping("/routesSortUp")
    public String routesSortUp(Model model){
        List<Routes> routesList = routeService.getAllRoutes();
        for (int j = 0; j <routesList.size() ; j++) {
            for (int i = 1; i < routesList.size(); i++) {
                if (routesList.get(i - 1).getAdress().toLowerCase().charAt(0) > routesList.get(i).getAdress().toLowerCase().charAt(0)) {
                    Routes tmpRoute = routesList.get(i - 1);
                    routesList.set(i - 1, routesList.get(i));
                    routesList.set(i, tmpRoute);
                }
            }
        }
        model.addAttribute("routes", routesList);

        refreshAttributes(model);

        return "allRoutes";
    }
    @RequestMapping("/routesSortDown")
    public String routesSortDown(Model model){
        List<Routes> routesList = routeService.getAllRoutes();
        for (int j = 0; j <routesList.size() ; j++) {
            for (int i = 1; i < routesList.size(); i++) {
                if (routesList.get(i - 1).getAdress().toLowerCase().charAt(0) < routesList.get(i).getAdress().toLowerCase().charAt(0)) {
                    Routes tmpRoute = routesList.get(i - 1);
                    routesList.set(i - 1, routesList.get(i));
                    routesList.set(i, tmpRoute);
                }
            }
        }
        model.addAttribute("routes", routesList);

        refreshAttributes(model);

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
