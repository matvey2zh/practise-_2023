package com.mozhzhey.spring.mvc_hibernate_aop.dao.Order;

import com.mozhzhey.spring.mvc_hibernate_aop.entity.Cars;
import com.mozhzhey.spring.mvc_hibernate_aop.entity.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrdersDaoImpl implements OrdersDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Orders> getAllOrders() {

        Session session = sessionFactory.getCurrentSession();
        List<Orders> ordersList = session.createQuery("from Orders",
                        Orders.class)
                .getResultList();
        return ordersList;
    }

    @Override
    public void deleteOrder(int id) {
        Session session = sessionFactory.getCurrentSession();
        Orders order = session.get(Orders.class,id);
        session.delete(order);
    }

    @Override
    public Orders getOrder(int id) {
        Session session = sessionFactory.getCurrentSession();

        Orders order = session.get(Orders.class, id);

        return order;
    }
}
