package com.mozhzhey.spring.mvc_hibernate_aop.controller;

import com.mozhzhey.spring.mvc_hibernate_aop.entity.Dispatchers;
import com.mozhzhey.spring.mvc_hibernate_aop.service.Dispatcher.DispatcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller()
public class DispatcherController {
    @Autowired
    private DispatcherService dispatcherService;


    @RequestMapping("/dispatchers")
    public String showAllDispatchers(Model model) {

        List<Dispatchers> dispatchersList = dispatcherService.getAllDispatchers();

        model.addAttribute("dispatchers", dispatchersList);

        Dispatchers dispatchers= new Dispatchers();
        model.addAttribute("dispatcher", dispatchers);

        return "allDispatchers";
    }
    @RequestMapping("/saveDispatcher")
    public String saveDispatcher(@ModelAttribute("dispatcher") Dispatchers dispatchers) {

        dispatcherService.saveDispatcher(dispatchers);

        return "redirect:/dispatchers";
    }

    @RequestMapping("/updateDispatcher")
    public String updateDispatcher(@RequestParam("dispId") int id, Model model) {
        Dispatchers dispatchers = dispatcherService.getDispatcher(id);

        model.addAttribute("dispatcher", dispatchers);

        return "dispatcher-info";
    }

    @RequestMapping("/deleteDispatcher")
    public String deleteDispatcher(@RequestParam("dispId") int id) {

        dispatcherService.deleteDispatcher(id);
        return "redirect:/dispatchers";
    }
}
