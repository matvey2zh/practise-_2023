package com.mozhzhey.spring.mvc_hibernate_aop.service.Order;

import com.mozhzhey.spring.mvc_hibernate_aop.entity.Drivers;
import com.mozhzhey.spring.mvc_hibernate_aop.entity.Orders;

import java.util.List;

public interface OrderService {
    public List<Orders> getAllOrders();

    public void saveOrder(Orders order);
    void updateOrder(Orders order);

    public void deleteOrder(int id);

    public Orders getOrder(int id);
}


