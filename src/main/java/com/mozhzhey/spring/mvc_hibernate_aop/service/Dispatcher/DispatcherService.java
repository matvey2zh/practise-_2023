package com.mozhzhey.spring.mvc_hibernate_aop.service.Dispatcher;

import com.mozhzhey.spring.mvc_hibernate_aop.entity.Dispatchers;

import java.util.List;

public interface DispatcherService {

    public List<Dispatchers> getAllDispatchers();

    public void saveDispatcher(Dispatchers dispatchers);

    public void deleteDispatcher(int id);

    public Dispatchers getDispatcher(int id);
}
