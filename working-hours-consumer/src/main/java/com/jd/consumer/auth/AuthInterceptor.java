package com.jd.consumer.auth;

import com.jd.consumer.service.InfoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	private InfoUserService infoUserService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Object o = session.getAttribute("user");
		if (o == null) {
			response.getWriter().print("没有登录");
			return false;
		}
		return true;
	}
}
