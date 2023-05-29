package com.mozhzhey.spring.mvc_hibernate_aop.controller;

import com.mozhzhey.spring.mvc_hibernate_aop.entity.Orders;
import com.mozhzhey.spring.mvc_hibernate_aop.service.Order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @RequestMapping("/routeInfo")
    public String routeInfo(Model model){

        return "reportsPages/reportsRoutesInfo.jsp";
    }
    @RequestMapping("/ordersByOneDriver")
    public String ordersByOneDriver(Model model){

        return "reportsPages/reportsOrdersByOneDriver.jsp";
    }
}
