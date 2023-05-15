package com.mozhzhey.spring.mvc_hibernate_aop.controller;


import com.mozhzhey.spring.mvc_hibernate_aop.entity.*;
import com.mozhzhey.spring.mvc_hibernate_aop.service.Order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller()
public class OrderController {

    @Autowired
    private OrderService ordersService;

    @RequestMapping("/orders")
    public String showAllOrders(Model model) {

        List<Orders> ordersList = ordersService.getAllOrders();
        model.addAttribute("orders", ordersList);

        return "allOrders";
    }



    @RequestMapping("/deleteOrder")
    public String deleteOrder(@RequestParam("orderId") int id) {

        ordersService.deleteOrder(id);
        return "redirect:/orders";
    }

}