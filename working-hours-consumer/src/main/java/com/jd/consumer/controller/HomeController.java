package com.jd.consumer.controller;

import com.jd.api.model.InfoModel;
import com.jd.consumer.annotation.Log;
import com.jd.consumer.service.stub.InfoServiceStub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class HomeController {
	@Autowired
	private InfoServiceStub infoServiceStub;

	@RequestMapping("/home")
	public ModelAndView home(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		Object o = session.getAttribute("user");
		if (o == null) {
			modelAndView.setViewName("redirect:/view/login");
			return modelAndView;
		}
		modelAndView.setViewName("home");
		modelAndView.addObject("user", o);
		return modelAndView;
	}

	@Log
	@RequestMapping("/info/name/{name}")
	@ResponseBody
	public List<InfoModel> getInfosByName(@PathVariable("name") String name) {
		return infoServiceStub.findInfosByName(name);
	}

	@Log
	@RequestMapping("/info/id/{id}")
	@ResponseBody
	public InfoModel findInfoById(@PathVariable("id") int id) {
		return infoServiceStub.findInfoById(id);
	}
}
