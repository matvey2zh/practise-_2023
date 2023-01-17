package com.mozhzhey.spring.mvc_hibernate_aop.dao.Order;

import com.mozhzhey.spring.mvc_hibernate_aop.entity.Orders;

import java.util.List;

public interface OrdersDAO {

    public List<Orders> getAllOrders();

    public void deleteOrder(int id);

    public Orders getOrder(int id);
}
