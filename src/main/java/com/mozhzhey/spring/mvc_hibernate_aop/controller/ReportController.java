package com.mozhzhey.spring.mvc_hibernate_aop.controller;

import com.mozhzhey.spring.mvc_hibernate_aop.entity.Drivers;
import com.mozhzhey.spring.mvc_hibernate_aop.entity.Orders;
import com.mozhzhey.spring.mvc_hibernate_aop.service.Drivers.DriverService;
import com.mozhzhey.spring.mvc_hibernate_aop.service.Order.OrderService;
import com.mozhzhey.spring.mvc_hibernate_aop.service.ReportHelper.ReportHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;
@Controller
public class ReportController {
    @RequestMapping("/reports")
    public String showReports(Model model) {


        return "reportsPages/reports.jsp";
    }


    @Autowired
    private OrderService ordersService;

    @RequestMapping("/timetable")
    public String timetable(Model model){
        List<Orders> ordersList = ordersService.getAllOrders();
        for (int i = 0; i < ordersList.size(); i++) {
            for (int j = 1; j < ordersList.size(); j++) {
                if(ordersList.get(j-1).getDateOfDispatch().compareTo(ordersList.get(j).getDateOfDispatch())>=1){
                    Orders ordersTmp =ordersList.get(j-1);
                    ordersList.set(j-1,ordersList.get(j));
                    ordersList.set(j,ordersTmp);
                }
            }
        }
        model.addAttribute("orders", ordersList);
        return "reportsPages/reportsTimetable.jsp";
    }

    @RequestMapping("/selectDriver")
    public String selectDriver(Model model,@RequestParam("driverId") int id ){

        List<Orders> ordersList = ordersService.getAllOrders();
        for (int j = 0; j < ordersList.size(); j++) {


            for (int i = 0; i < ordersList.size(); i++) {
                if (ordersList.get(i).getDriver().getId() != id) {
                    ordersList.remove(i);
                }
            }
        }

        List<Drivers> driversList = driverService.getAllDrivers();
        model.addAttribute("drivers", driversList);

        ReportHelper helper= new ReportHelper();
        int amount=0;
        LocalDate startDate;
        LocalDate endDate;
        for (int i = 0; i < ordersList.size(); i++) {
            startDate=LocalDate.of(ordersList.get(i).getDateOfDispatch().getYear(),ordersList.get(i).getDateOfDispatch().getMonth(),ordersList.get(i).getDateOfDispatch().getDay());
            endDate=LocalDate.of(ordersList.get(i).getDateOfAcceptance().getYear(),ordersList.get(i).getDateOfAcceptance().getMonth(),ordersList.get(i).getDateOfAcceptance().getDay());
            amount+= ChronoUnit.DAYS.between(startDate, endDate);

        }
        helper.setAmountOfDaysAll(amount);
        helper.setAmountOfRoutes(ordersList.size());
        helper.setAmountOfDaysLastMonth(ordersList.size());

        List<ReportHelper> listHelper=new ArrayList<>(1) ;
        listHelper.add(helper);
        model.addAttribute("reportHelper", listHelper);

        model.addAttribute("orders", ordersList);
        return   "reportsPages/reportsOrdersByOneDriver.jsp";
    }

    @Autowired
    DriverService driverService;
    @RequestMapping("/routeInfo")
    public String routeInfo(Model model){
        return "reportsPages/reportsRoutesInfo.jsp";
    }
    @RequestMapping("/ordersByOneDriver")
    public String ordersByOneDriver(Model model){
        List<Drivers> driversList = driverService.getAllDrivers();
        model.addAttribute("drivers", driversList);
        refresh(model);
        return "reportsPages/reportsOrdersByOneDriver.jsp";
    }


    public void refresh(Model model){
        List<Orders> ordersList = null;
        model.addAttribute("orders",ordersList);
        List<ReportHelper> listHelper=null;
        model.addAttribute("reportHelper", listHelper);
    }
}
