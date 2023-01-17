package com.mozhzhey.spring.mvc_hibernate_aop.dao.Dispatcher;

import com.mozhzhey.spring.mvc_hibernate_aop.entity.Cars;
import com.mozhzhey.spring.mvc_hibernate_aop.entity.Dispatchers;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class DispatchersDAOImpl implements DispatchersDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Dispatchers> getAllDispatchers() {

        Session session = sessionFactory.getCurrentSession();
        List<Dispatchers> dispatchersList = session.createQuery("from Dispatchers",
                Dispatchers.class)
                .getResultList();
        return dispatchersList;
    }

    @Override
    public void saveDispatcher(Dispatchers dispatchers) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(dispatchers);
    }

    @Override
    public void deleteDispatcher(int id) {
        Session session = sessionFactory.getCurrentSession();
        Dispatchers dispatchers = session.get(Dispatchers.class,id);
        session.delete(dispatchers);
    }

    @Override
    public Dispatchers getDispatcher(int id) {
        Session session = sessionFactory.getCurrentSession();

        Dispatchers dispatchers = session.get(Dispatchers.class, id);

        return dispatchers;
    }
}
