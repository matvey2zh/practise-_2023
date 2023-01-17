package com.mozhzhey.spring.mvc_hibernate_aop.dao.Dispatcher;


import com.mozhzhey.spring.mvc_hibernate_aop.entity.Dispatchers;

import java.util.List;

public interface DispatchersDAO {
    public List<Dispatchers> getAllDispatchers();

    public void saveDispatcher(Dispatchers dispatchers);

    public void deleteDispatcher(int id);

    public Dispatchers getDispatcher(int id);
}
