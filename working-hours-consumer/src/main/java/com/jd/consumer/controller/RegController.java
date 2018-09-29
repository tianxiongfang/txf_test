package com.jd.consumer.controller;

import com.jd.api.model.CodeMQMsgModel;
import com.jd.consumer.model.InfoUserModel;
import com.jd.consumer.service.ActiveMQService;
import com.jd.consumer.service.InfoUserService;
import com.jd.consumer.service.RedisService;
import com.jd.consumer.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/view")
public class RegController {
	@Autowired
	private RedisService redisService;
	@Autowired
	private ActiveMQService activeMQService;
	@Autowired
	private InfoUserService infoUserService;

	@RequestMapping("/reg")
	public ModelAndView reg(HttpServletRequest request) {
		ModelAndView view = new ModelAndView("reg");
		String email = (String) request.getSession().getAttribute("email");
		if (email != null) {
			long expire = redisService.getExpire(email + ":interval");
			view.addObject("expire", expire);
		}
		return view;
	}

	@ResponseBody
	@RequestMapping(value = "/sendcode", method = RequestMethod.POST)
	public boolean sendRegCode(HttpSession session, @RequestParam("email") String email) {
		session.setAttribute("email", email);
		//键过期时间
		long expire = redisService.getExpire(email + ":interval");
		if (expire > 0) {
			return false;
		}
		String code = UUIDUtil.getCode();
		//验证码至少隔150秒才能再次获取
		redisService.setStr(email + ":interval", email, 150, TimeUnit.SECONDS);
		//验证码有效期900秒，过期将失效
		redisService.setStr(email + ":expire", code, 900, TimeUnit.SECONDS);
		CodeMQMsgModel codeMQMsgModel = new CodeMQMsgModel();
		codeMQMsgModel.setCode(code);
		codeMQMsgModel.setEmailAddr(email);
		activeMQService.sendCode(codeMQMsgModel);
		return true;
	}

	@RequestMapping(value = "/doreg", method = RequestMethod.POST)
	@ResponseBody
	public int doReg(HttpServletRequest request, @RequestParam("email") String email,
	                 @RequestParam("code") String code,
	                 @RequestParam("password") String password) {
		String redisCode = redisService.getStr(email + ":expire");
		if (redisCode == null) {
			return -1;//验证码已失效
		}

		if (redisCode.equals(code.toUpperCase())) {
			redisService.delKey(email + ":expire");
			InfoUserModel model = infoUserService.findUserByEmail(email);
			if (model != null) {
				return -2;//邮件已注册
			}
			InfoUserModel infoUserModel = new InfoUserModel();
			infoUserModel.setEmail(email);
			infoUserModel.setPassword(password);
			request.getSession().setAttribute("user", infoUserModel);
			infoUserService.addUser(infoUserModel);
			return 1;//验证码正确
		}

		return 0;//验证码错误
	}

}
