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

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
        Date startDate = newOrder.getDateOfDispatch();
        Date endDate = newOrder.getDateOfAcceptance();




        List <Drivers> driversList = driverService.getAllDrivers();
        List <Drivers> tmp = new ArrayList<>();
            for (int i = 0; i < driversList.size(); i++) {
                if(isDriverFree(driversList.get(i),startDate,endDate)){
                   tmp.add(driversList.get(i));
                }
            }



        model.addAttribute("drivers", tmp);


        return "choosePages/forOrder/chooseDriverForOrder.jsp";
    }



    private boolean isDriverFree(Drivers driver, Date startDate, Date endDate){
        List<Orders> ordersList = ordersService.getAllOrders();
        for (int i = 0; i < ordersList.size(); i++) {
            if(ordersList.get(i).getDriver().getId()==driver.getId()) {
                if(startDate.after(ordersList.get(i).getDateOfAcceptance()) || endDate.before(ordersList.get(i).getDateOfDispatch())){

                }else {
                    return  false;
                }
            }
        }
        return true;
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
    @RequestMapping("/updateOrderCondition")
    public String updateOrderCondition(Model model,@RequestParam("orderId") int id){
        model.addAttribute("order",ordersService.getOrder(id));

        return "/refactorPages/order-info.jsp";
    }


    void refreshAttributes(Model model){
        SearchHelper searchHelper= new SearchHelper(new String());
        model.addAttribute("searchInfo",searchHelper);
        Orders order = new Orders();
        model.addAttribute("order", order);
    }


    @RequestMapping("/saveOrder")
    public String saveOrder(@ModelAttribute("order") Orders order) {
        Orders tmp = ordersService.getOrder(order.getId());
        tmp.setOrderCondition(order.getOrderCondition());
        ordersService.saveOrder(tmp);
        return "redirect:/orders";
    }
}