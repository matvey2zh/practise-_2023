package com.mozhzhey.spring.mvc_hibernate_aop.controller;

import com.mozhzhey.spring.mvc_hibernate_aop.entity.Cars;
import com.mozhzhey.spring.mvc_hibernate_aop.entity.Drivers;
import com.mozhzhey.spring.mvc_hibernate_aop.service.Cars.CarService;
import com.mozhzhey.spring.mvc_hibernate_aop.service.Drivers.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller()
public class DriverController {
    @Autowired
    private DriverService driverService;

    @RequestMapping("/drivers")
    public String showAllDrivers(Model model) {
        List<Drivers> driversList = driverService.getAllDrivers();
//        Collections.sort(driversList);
        model.addAttribute("drivers", driversList);

        Drivers drivers = new Drivers();
        model.addAttribute("driver",drivers);

        return "allDrivers";
    }
    @Autowired
    private CarService carService;


    private Drivers newDriver;
    private int editedDriverID;
    @RequestMapping("/addNewDriver1")
    public String addNewDriver1(Model model,@ModelAttribute("driver") Drivers driver) {
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
        driverService.updateDriver(newDriver);

        return "redirect:/drivers";
    }

    @RequestMapping("/editDriver")
    public String editDriver(Model model,@ModelAttribute("driver1") Drivers driver) {
        List<Cars> carsList = carService.getAllCars();
        model.addAttribute("cars", carsList);

        newDriver=driver;

        return "chooseCarForDriver";
    }
    @RequestMapping("/saveDriver")
    public String saveDriver(@ModelAttribute("driver1") Drivers driver) {

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
}
