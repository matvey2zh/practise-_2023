package com.mozhzhey.spring.mvc_hibernate_aop.controller;


import com.mozhzhey.spring.mvc_hibernate_aop.entity.*;
import com.mozhzhey.spring.mvc_hibernate_aop.service.Dispatcher.DispatcherService;
import com.mozhzhey.spring.mvc_hibernate_aop.service.Drivers.DriverService;
import com.mozhzhey.spring.mvc_hibernate_aop.service.Order.OrderService;
import com.mozhzhey.spring.mvc_hibernate_aop.service.Routes.RouteService;
import com.mozhzhey.spring.mvc_hibernate_aop.service.SearchHelper.SearchHelper;
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

        refreshAttributes(model);

        return "mainPages/allOrders.jsp";
    }

    @Autowired
    private DispatcherService dispatcherService;
    private Orders newOrder;
    @RequestMapping("/addNewOrder")
    public String addNewOrder(Model model, @ModelAttribute("order") Orders order) {
        newOrder = order;
        System.out.println(newOrder);
        List<Dispatchers> dispatchersList = dispatcherService.getAllDispatchers();

        model.addAttribute("dispatchers", dispatchersList);


        return "choosePages/forOrder/chooseDispatcherForOrder.jsp";
    }
    @Autowired
    private DriverService driverService;

    @RequestMapping("/saveDispatcherForOrder")
    public String saveDispatcherForOrder(@RequestParam("selectDispId") int id, Model model) {
        newOrder.setDispatcher(dispatcherService.getDispatcher(id));
//        ordersService.updateOrder(newOrder);
        List <Drivers> driversList = driverService.getAllDrivers();
        model.addAttribute("drivers", driversList);
        System.out.println(newOrder);


        return "choosePages/forOrder/chooseDriverForOrder.jsp";
    }
    @Autowired
    private RouteService routeService;
    @RequestMapping("/saveDriverForOrder")
    public String saveDriverForOrder(@RequestParam("selectDriverId") int id, Model model) {
        newOrder.setDriver(driverService.getDriver(id));
//        ordersService.updateOrder(newOrder);
        List<Routes> routesList = routeService.getAllRoutes();
        model.addAttribute("routes", routesList);


        return "choosePages/forOrder/chooseRouteDepartureForOrder.jsp";
    }
    @RequestMapping("/saveRouteDepartureForOrder")
    public String saveRouteDepartureForOrder(@RequestParam("selectRouteDepartureId") int id, Model model) {
        newOrder.setDepartureAdress(routeService.getRoutes(id));
//        ordersService.updateOrder(newOrder);
        List<Routes> routesList = routeService.getAllRoutes();
        model.addAttribute("routes", routesList);


        return "choosePages/forOrder/chooseRouteDeliveryForOrder.jsp";
    }
    @RequestMapping("/saveRouteDeliveryForOrder")
    public String saveRouteDeliveryForOrder(@RequestParam("selectRouteDepartureId") int id, Model model) {
        newOrder.setDeliveryAdress(routeService.getRoutes(id));
//        ordersService.updateOrder(newOrder);
        ordersService.saveOrder(newOrder);


        return "redirect:/orders";
    }
    @RequestMapping("/deleteOrder")
    public String deleteOrder(@RequestParam("orderId") int id) {

        ordersService.deleteOrder(id);
        return "redirect:/orders";
    }



    void refreshAttributes(Model model){
        SearchHelper searchHelper= new SearchHelper(new String());
        model.addAttribute("searchInfo",searchHelper);
        Orders order = new Orders();
        model.addAttribute("order", order);
    }
    @RequestMapping("/reference")
    public String reference(Model model) {

        return "mainPages/reference.pdf";
    }
}