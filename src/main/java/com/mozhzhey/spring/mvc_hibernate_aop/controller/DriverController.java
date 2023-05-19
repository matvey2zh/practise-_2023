package com.mozhzhey.spring.mvc_hibernate_aop.controller;

import com.mozhzhey.spring.mvc_hibernate_aop.entity.Cars;
import com.mozhzhey.spring.mvc_hibernate_aop.entity.Drivers;
import com.mozhzhey.spring.mvc_hibernate_aop.entity.Routes;
import com.mozhzhey.spring.mvc_hibernate_aop.service.Cars.CarService;
import com.mozhzhey.spring.mvc_hibernate_aop.service.Drivers.DriverService;
import com.mozhzhey.spring.mvc_hibernate_aop.service.SearchHelper.SearchHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

@Controller()
public class DriverController {
    @Autowired
    private DriverService driverService;

    @RequestMapping("/drivers")
    public String showAllDrivers(Model model) {
        List<Drivers> driversList = driverService.getAllDrivers();
        model.addAttribute("drivers", driversList);

        refreshAttributes(model);

        return "allDrivers";
    }
    @Autowired
    private CarService carService;

    void refreshAttributes(Model model){
        SearchHelper searchHelper= new SearchHelper(new String());
        model.addAttribute("searchInfo",searchHelper);
        Drivers driver = new Drivers();
        model.addAttribute("driver", driver);
    }

    @RequestMapping("/searchInfoInDrivers")
    public String searchInfoInDrivers(Model model,@ModelAttribute("searchInfo") SearchHelper info){
        List<Drivers> driversList = driverService.getAllDrivers();
        for (int j = 0; j < driversList.size(); j++) {
            for (int i = 0; i < driversList.size(); i++) {
                if (!driversList.get(i).getName().toLowerCase().contains(info.getInfo().toLowerCase()) &&
                        !Integer.toString(driversList.get(i).getWorkExperience()).toLowerCase().contains(info.getInfo())) {
                    driversList.remove(i);
                }

            }
        }
        model.addAttribute("drivers", driversList);
        refreshAttributes(model);
        return "allDrivers";

    }

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

    @RequestMapping("/driversSortByNameUp")
    public String driversSortByNameUp(Model model){
        List<Drivers> driversList = driverService.getAllDrivers();
        for (int j = 0; j <driversList.size() ; j++) {
            for (int i = 1; i < driversList.size(); i++) {
                if (driversList.get(i - 1).getName().toLowerCase().charAt(0) > driversList.get(i).getName().toLowerCase().charAt(0)) {
                    Drivers tmpDriver = driversList.get(i - 1);
                    driversList.set(i - 1, driversList.get(i));
                    driversList.set(i, tmpDriver);
                }
            }
        }
        model.addAttribute("drivers", driversList);

        refreshAttributes(model);

        return "allDrivers";
    }
    @RequestMapping("/driversSortByNameDown")
    public String driversSortByNameDown(Model model){
        List<Drivers> driversList = driverService.getAllDrivers();
        for (int j = 0; j <driversList.size() ; j++) {
            for (int i = 1; i < driversList.size(); i++) {
                if (driversList.get(i - 1).getName().toLowerCase().charAt(0) < driversList.get(i).getName().toLowerCase().charAt(0)) {
                    Drivers tmpDriver = driversList.get(i - 1);
                    driversList.set(i - 1, driversList.get(i));
                    driversList.set(i, tmpDriver);
                }
            }
        }
        model.addAttribute("drivers", driversList);

        refreshAttributes(model);


        return "allDrivers";
    }
    @RequestMapping("/driversSortByYearUp")
    public String driversSortByYearUp(Model model) {
        List<Drivers> driversList = driverService.getAllDrivers();
        for (int j = 0; j < driversList.size(); j++) {
            for (int i = 1; i < driversList.size(); i++) {
                if (driversList.get(i - 1).getWorkExperience() > driversList.get(i).getWorkExperience()) {
                    Drivers tmpDriver = driversList.get(i - 1);
                    driversList.set(i - 1, driversList.get(i));
                    driversList.set(i, tmpDriver);
                }
            }
        }
        model.addAttribute("drivers", driversList);

        refreshAttributes(model);
        ;
        return "allDrivers";
    }
    @RequestMapping("/driversSortByYearDown")
    public String driversSortByYearDown(Model model) {
        List<Drivers> driversList = driverService.getAllDrivers();
        for (int j = 0; j < driversList.size(); j++) {
            for (int i = 1; i < driversList.size(); i++) {
                if (driversList.get(i - 1).getWorkExperience() < driversList.get(i).getWorkExperience()) {
                    Drivers tmpDriver = driversList.get(i - 1);
                    driversList.set(i - 1, driversList.get(i));
                    driversList.set(i, tmpDriver);
                }
            }
        }
        model.addAttribute("drivers", driversList);

        refreshAttributes(model);

        return "allDrivers";
    }




}
