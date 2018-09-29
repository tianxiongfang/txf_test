package com.jd.consumer.controller;

import com.jd.consumer.service.stub.InfoServiceStub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2018/9/13.
 */
@Controller
public class ServiceController {
    @Autowired
    private InfoServiceStub infoServiceStub;

    @RequestMapping("/service")
    public ModelAndView home(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        Object o = session.getAttribute("user");
        if (o == null) {
            modelAndView.setViewName("redirect:/view/login");
            return modelAndView;
        }
        modelAndView.setViewName("service");
        modelAndView.addObject("user", o);
        return modelAndView;
    }
}
