package com.jd.consumer.controller;

import com.jd.consumer.model.InfoUserModel;
import com.jd.consumer.service.InfoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/view")
public class LoginController {
	@Autowired
	private InfoUserService infoUserService;

	@RequestMapping("/login")
	public ModelAndView login(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("login");
		InfoUserModel userModel = (InfoUserModel) session.getAttribute("userModel");

		if (userModel != null) {
			modelAndView.addObject("userModel", userModel);
		}
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping(value = "/dologin", consumes = "application/json")
	public int doLogin(HttpSession session, @RequestBody InfoUserModel userModel) {
		int flag = infoUserService.doLogin(userModel);
		if (flag == 1) {
			session.setAttribute("user", userModel.getEmail());
		}
		return flag;
	}
	@RequestMapping("/getseansession")
	@ResponseBody
	public Map<String,String> getSession(HttpServletRequest request){
		Map<String,String> attributeMap = new HashMap<String, String>();
		request.getSession().setAttribute("message", request.getRequestURI());
		attributeMap.put("message", request.getRequestURI());
		System.out.println("sessionID:" + request.getSession().getId());
		return attributeMap;
	}
}
