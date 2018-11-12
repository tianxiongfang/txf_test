package com.jd.consumer.controller;

import com.jd.api.model.BlogVO;
import com.jd.api.service.BlogService;
import com.jd.consumer.model.Blog;
import com.jd.consumer.service.stub.InfoServiceStub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2018/9/13.
 */
@Controller
public class BlogController {
    @Autowired
    private InfoServiceStub infoServiceStub;
   @Autowired
    private BlogService blogService;
    @RequestMapping("/blog")
    public ModelAndView home(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        Object o = session.getAttribute("user");
        if (o == null) {
            modelAndView.setViewName("redirect:/view/login");
            return modelAndView;
        }
        modelAndView.setViewName("blog");
        modelAndView.addObject("user", o);
        return modelAndView;
    }
    @ResponseBody
    @RequestMapping("/getBlog")
    public List<BlogVO> getBlog(){
          return blogService.getBlog();
    }

    @ResponseBody
    @RequestMapping("/getBlogNew")
    public List<BlogVO> getBlogNew(){
        return blogService.getBlogNew();
    }
}
