package com.mozhzhey.spring.mvc_hibernate_aop.controller;

import com.mozhzhey.spring.mvc_hibernate_aop.entity.Dispatchers;
import com.mozhzhey.spring.mvc_hibernate_aop.service.Dispatcher.DispatcherService;
import com.mozhzhey.spring.mvc_hibernate_aop.service.SearchHelper.SearchHelper;
import com.mozhzhey.spring.mvc_hibernate_aop.service.loginHelper.LoginHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class LoginController {

    @RequestMapping("/openLoginPage")
    public String openLoginPage(Model model) {
        LoginHelper helper =  new LoginHelper();

        model.addAttribute("loginDispatcher",helper);

        return "loginPages/loginPage.jsp";
    }


    @Autowired
    DispatcherService dispatcherService;
    @RequestMapping("/checkUser")
    public String checkUser(Model model,@ModelAttribute("loginDispatcher")LoginHelper helper) {
        List<Dispatchers> dispatchersList = dispatcherService.getAllDispatchers();
        for (int i = 0; i < dispatchersList.size(); i++) {
            if(dispatchersList.get(i).getName().equalsIgnoreCase(helper.getName())  &&
                    dispatchersList.get(i).getSurname().equalsIgnoreCase(helper.getSurname())  &&
                    dispatchersList.get(i).getPassword().equalsIgnoreCase(helper.getPassword())) {
                return "redirect:/orders";
            }
        }
        return "loginPages/failLoginPage.jsp";
    }
    @RequestMapping("/currentUserPage")
    public String currentUserPage(Model model) {
        LoginHelper helper =  new LoginHelper();

        model.addAttribute("loginDispatcher",helper);

        return "loginPages/currentUserPage.jsp";
    }
}
