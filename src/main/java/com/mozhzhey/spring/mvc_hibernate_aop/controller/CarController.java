package com.mozhzhey.spring.mvc_hibernate_aop.controller;

import com.mozhzhey.spring.mvc_hibernate_aop.entity.Cars;
import com.mozhzhey.spring.mvc_hibernate_aop.service.Cars.CarService;
import com.mozhzhey.spring.mvc_hibernate_aop.service.SearchHelper.SearchHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller()
public class CarController {
    @Autowired
    private CarService carService;

    @RequestMapping("/cars")
    public String showAllCars(Model model) {

        List<Cars> carsList = carService.getAllCars();
        model.addAttribute("cars", carsList);

        refreshAttributes(model);
        return "mainPages/allCars.jsp";
    }

    void refreshAttributes(Model model){
        SearchHelper searchHelper= new SearchHelper(new String());
        model.addAttribute("searchInfo",searchHelper);
        Cars car = new Cars();
        model.addAttribute("car", car);
    }

    @RequestMapping("/carsSortByYearUp")
    public String carsSortByYearUp(Model model){
        List<Cars> carsList = carService.getAllCars();
        for (int j = 0; j < carsList.size(); j++) {
            for (int i = 1; i < carsList.size(); i++) {
                if (carsList.get(i - 1).getYearOfRelease() > carsList.get(i).getYearOfRelease()) {
                    Cars tmpCar = carsList.get(i - 1);
                    carsList.set(i - 1, carsList.get(i));
                    carsList.set(i, tmpCar);
                }
            }
        }
        model.addAttribute("cars", carsList);
        refreshAttributes(model);
        return "mainPages/allCars.jsp";
    }

    @RequestMapping("/carsSortByYearDown")
    public String carsSortByYearDown(Model model){
        List<Cars> carsList = carService.getAllCars();
        for (int j = 0; j < carsList.size(); j++) {
            for (int i = 1; i < carsList.size(); i++) {
                if (carsList.get(i - 1).getYearOfRelease() < carsList.get(i).getYearOfRelease()) {
                    Cars tmpCar = carsList.get(i - 1);
                    carsList.set(i - 1, carsList.get(i));
                    carsList.set(i, tmpCar);
                }
            }
        }
        model.addAttribute("cars", carsList);
        refreshAttributes(model);

        return "mainPages/allCars.jsp";

    }
    @RequestMapping("/carsSortByModelUp")
    public String carsSortByModelUp(Model model){
        List<Cars> carsList = carService.getAllCars();
        for (int j = 0; j < carsList.size(); j++) {
            for (int i = 1; i < carsList.size(); i++) {
                if (carsList.get(i - 1).getBrand().toLowerCase().charAt(0) > carsList.get(i).getBrand().toLowerCase().charAt(0)) {
                    Cars tmpCar = carsList.get(i - 1);
                    carsList.set(i - 1, carsList.get(i));
                    carsList.set(i, tmpCar);
                }
            }
        }
        model.addAttribute("cars", carsList);
        refreshAttributes(model);

        return "mainPages/allCars.jsp";

    }

    @RequestMapping("/carsSortByModelDown")
    public String carsSortByModelDown(Model model){
        List<Cars> carsList = carService.getAllCars();
        for (int j = 0; j < carsList.size(); j++) {
            for (int i = 1; i < carsList.size(); i++) {
                if (carsList.get(i - 1).getBrand().toLowerCase().charAt(0) < carsList.get(i).getBrand().toLowerCase().charAt(0)) {
                    Cars tmpCar = carsList.get(i - 1);
                    carsList.set(i - 1, carsList.get(i));
                    carsList.set(i, tmpCar);
                }
            }
        }
        model.addAttribute("cars", carsList);
        refreshAttributes(model);
        return "mainPages/allCars.jsp";

    }



    @RequestMapping("/searchInfoInCars")
    public String searchInfoInCars(Model model,@ModelAttribute("searchInfo") SearchHelper info){
        List<Cars> carsList = carService.getAllCars();
            for (int i = 0; i < carsList.size(); i++) {
                if( !carsList.get(i).getBrand().toLowerCase().contains(info.getInfo().toLowerCase()) &&
                        !carsList.get(i).getModel().toLowerCase().contains(info.getInfo().toLowerCase()) &&
                        !Integer.toString(carsList.get(i).getYearOfRelease()).toLowerCase().contains(info.getInfo()) ){
                    carsList.remove(i);
                    i=0;
                }

            }

        model.addAttribute("cars", carsList);
        refreshAttributes(model);
        return "mainPages/allCars.jsp";

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

        return "refactorPages/car-info.jsp";
    }

    @RequestMapping("/deleteCar")
    public String deleteCarButton(@RequestParam("carId") int id) {

        carService.deleteCar(id);
        return "redirect:/cars";
    }
}
