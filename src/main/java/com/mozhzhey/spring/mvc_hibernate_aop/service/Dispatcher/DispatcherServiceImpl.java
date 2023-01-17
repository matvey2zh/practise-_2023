package com.mozhzhey.spring.mvc_hibernate_aop.service.Dispatcher;

import com.mozhzhey.spring.mvc_hibernate_aop.dao.Dispatcher.DispatchersDAO;
import com.mozhzhey.spring.mvc_hibernate_aop.entity.Dispatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DispatcherServiceImpl implements DispatcherService {

    @Autowired
    private DispatchersDAO dispatchersDAO;

    @Override
    @Transactional
    public List<Dispatchers> getAllDispatchers() {
        return dispatchersDAO.getAllDispatchers();
    }

    @Override
    @Transactional
    public void saveDispatcher(Dispatchers dispatchers) {
        dispatchersDAO.saveDispatcher(dispatchers);
    }

    @Override
    @Transactional
    public void deleteDispatcher(int id) {
        dispatchersDAO.deleteDispatcher(id);
    }

    @Override
    @Transactional
    public Dispatchers getDispatcher(int id) {
        return dispatchersDAO.getDispatcher(id);
    }
}
