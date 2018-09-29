package com.jd.consumer.aop;

import com.jd.consumer.service.RequestLogHandler;
import com.jd.consumer.util.thread.MultiThreadRunner;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Aspect
@Component
public class LogAspect {

	@Pointcut("@annotation(com.jd.consumer.annotation.Log)")
	public void pointCut() {
	}

	@Around("pointCut()")
	public Object around(ProceedingJoinPoint proceedingJoinPoint) {
		Object result = null;
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		HttpSession session = request.getSession();
		long beginTime = System.currentTimeMillis();
		try {
			result = proceedingJoinPoint.proceed();
		} catch (Throwable throwable) {
			throwable.printStackTrace();
			long costTime = System.currentTimeMillis() - beginTime;
		}
		long costTime = System.currentTimeMillis() - beginTime;

		new MultiThreadRunner("request-log-handler-thread",
				new RequestLogHandler(proceedingJoinPoint, costTime, request, session)).start();

		return result;
	}
}
