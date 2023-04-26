package com.mozhzhey.spring.mvc_hibernate_aop.controller;


import com.mozhzhey.spring.mvc_hibernate_aop.entity.*;
import com.mozhzhey.spring.mvc_hibernate_aop.service.Cars.CarService;
import com.mozhzhey.spring.mvc_hibernate_aop.service.Dispatcher.DispatcherService;
import com.mozhzhey.spring.mvc_hibernate_aop.service.Drivers.DriverService;
import com.mozhzhey.spring.mvc_hibernate_aop.service.Order.OrderService;
import com.mozhzhey.spring.mvc_hibernate_aop.service.Routes.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller()
public class MyController {

    @Autowired
    private DispatcherService dispatcherService;


    @RequestMapping("/dispatchers")
    public String showAllDispatchers(Model model) {

        List<Dispatchers> dispatchersList = dispatcherService.getAllDispatchers();
        model.addAttribute("dispatchers", dispatchersList);

        Dispatchers dispatchers= new Dispatchers();
        model.addAttribute("dispatcher", dispatchers);

        return "allDispatchers";
    }


    @Autowired
    private OrderService ordersService;

    @RequestMapping("/orders")
    public String showAllOrders(Model model) {

        List<Orders> ordersList = ordersService.getAllOrders();
        model.addAttribute("orders", ordersList);

        return "allOrders";
    }


    @Autowired
    private DriverService driverService;

    @RequestMapping("/drivers")
    public String showAllDrivers(Model model) {

        List<Drivers> driversList = driverService.getAllDrivers();
        model.addAttribute("drivers", driversList);

        Drivers drivers = new Drivers();
        model.addAttribute("driver",drivers);

        return "allDrivers";
    }


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


    @Autowired
    private CarService carService;

    @RequestMapping("/cars")
    public String showAllCars(Model model) {

        List<Cars> carsList = carService.getAllCars();
        model.addAttribute("cars", carsList);


        Cars car = new Cars();
        model.addAttribute("car", car);
        return "allCars";
    }




    @RequestMapping("/saveCar")
    public String saveCar(@ModelAttribute("car") Cars car) {

        carService.saveCar(car);

        return "redirect:/cars";
    }

    @RequestMapping("/updateCar")
    public String updateCar(@RequestParam("carId") int id, Model model) {
        Cars car = carService.getCar(id);

        model.addAttribute("car", car);

        return "car-info";
    }

    @RequestMapping("/deleteCar")
    public String deleteCarButton(@RequestParam("carId") int id) {

        carService.deleteCar(id);
        return "redirect:/cars";
    }

    private Drivers newDriver;
    @RequestMapping("/addNewDriver1")
    public String addNewDriver1(Model model,@ModelAttribute("driver") Drivers driver) {
        List<Cars> carsList = carService.getAllCars();
        model.addAttribute("cars", carsList);

        newDriver=driver;

        return "chooseCarForDriver";
    }
    @RequestMapping("/editDriver")
    public String editDriver(Model model,@ModelAttribute("driver1") Drivers driver) {
        List<Cars> carsList = carService.getAllCars();
        model.addAttribute("cars", carsList);

        newDriver=driver;

        return "chooseCarForDriver";
    }

    private Cars selectedCar;

    @RequestMapping("/addNewDriver2")
    public String addNewDriver2(@RequestParam("selectCarId") int id) {
        Cars car = carService.getCar(id);
        selectedCar = car;

        newDriver.setDriverCar(selectedCar);
        driverService.saveDriver(newDriver);

        return "redirect:/drivers";
    }


    @RequestMapping("/saveDriver")
    public String saveDriver(@ModelAttribute("driver") Drivers driver) {

        driver.setDriverCar(selectedCar);
        driverService.saveDriver(driver);

        return "redirect:/drivers";
    }

    @RequestMapping("/updateDriver")
    public String updateDriver(@RequestParam("driverId") int id, Model model) {
        Drivers drivers = driverService.getDriver(id);
        model.addAttribute("driver1", drivers);

        return "driver-info";
    }
    @RequestMapping("/deleteDriver")
    public String deleteDriver(@RequestParam("driverId") int id) {

        driverService.deleteDriver(id);
        return "redirect:/drivers";
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




    @RequestMapping("/saveDispatcher")
    public String saveDispatcher(@ModelAttribute("dispatcher") Dispatchers dispatchers) {

        dispatcherService.saveDispatcher(dispatchers);

        return "redirect:/dispatchers";
    }

    @RequestMapping("/updateDispatcher")
    public String updateDispatcher(@RequestParam("dispId") int id, Model model) {
        Dispatchers dispatchers = dispatcherService.getDispatcher(id);

        model.addAttribute("dispatcher", dispatchers);

        return "dispatcher-info";
    }

    @RequestMapping("/deleteDispatcher")
    public String deleteDispatcher(@RequestParam("dispId") int id) {

        dispatcherService.deleteDispatcher(id);
        return "redirect:/dispatchers";
    }


    @RequestMapping("/deleteOrder")
    public String deleteOrder(@RequestParam("orderId") int id) {

        ordersService.deleteOrder(id);
        return "redirect:/orders";
    }

}