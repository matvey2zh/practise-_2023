package com.mozhzhey.spring.mvc_hibernate_aop.service.Order;

import com.mozhzhey.spring.mvc_hibernate_aop.dao.Order.OrdersDAO;
import com.mozhzhey.spring.mvc_hibernate_aop.entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrdersDAO ordersDAO;

    @Override
    @Transactional
    public List<Orders> getAllOrders() {
        return ordersDAO.getAllOrders();
    }
    @Override
    @Transactional
    public void saveOrder(Orders order) {
        ordersDAO.saveOrder(order);
    }

    @Override
    public void updateOrder(Orders order) {
        ordersDAO.updateOrder(order);
    }

    @Override
    @Transactional
    public void deleteOrder(int id) {
        ordersDAO.deleteOrder(id);
    }

    @Override
    @Transactional
    public Orders getOrder(int id) {
        return ordersDAO.getOrder(id);
    }
}
