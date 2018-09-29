package com.jd.consumer.service;

import com.jd.api.model.RequestLogMQMsgModel;
import com.jd.consumer.util.DateFormatUtil;
import com.jd.consumer.util.thread.Callback;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.EncodeException;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class RequestLogHandler implements Callback {
	private static final Logger LOGGER = LoggerFactory.getLogger(RequestLogHandler.class);
	private ProceedingJoinPoint proceedingJoinPoint;
	private long costTime;
	private HttpServletRequest request;
	private HttpSession session;
	@Autowired
	private ActiveMQService activeMQService;
	@Autowired
	private RedisService redisService;
	@Autowired
	private WebsocketService websocketService;
	private static RequestLogHandler requestLogHandler;

	public RequestLogHandler() {
	}

	@PostConstruct
	public void init() {
		requestLogHandler = this;
		requestLogHandler.activeMQService = this.activeMQService;
		requestLogHandler.redisService = this.redisService;
		requestLogHandler.websocketService = this.websocketService;
	}

	public RequestLogHandler(ProceedingJoinPoint proceedingJoinPoint, long costTime, HttpServletRequest request, HttpSession session) {
		this.proceedingJoinPoint = proceedingJoinPoint;
		this.costTime = costTime;
		this.request = request;
		this.session = session;
	}

	@Override
	public void run() {
		MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
		Method method = methodSignature.getMethod();
		String methodName = method.getName();
		LocalVariableTableParameterNameDiscoverer l = new LocalVariableTableParameterNameDiscoverer();
		String[] paramNames = l.getParameterNames(method);
		Class<?>[] clss = method.getParameterTypes();
		String[] paramTypes = new String[clss.length];
		for (int i = 0; i < clss.length; i++) {
			paramTypes[i] = clss[i].getName();
		}

		Object[] paramsValues = proceedingJoinPoint.getArgs();
		for (int i = 0; i < paramsValues.length; i++) {
			Object o = paramsValues[i];
			if (!(o instanceof Serializable)) {
				paramsValues[i] = o.getClass().getName();
			}
		}
		RequestLogMQMsgModel requestLogMQMsgModel = new RequestLogMQMsgModel();
		requestLogMQMsgModel.setMethodName(methodName);
		requestLogMQMsgModel.setCostTime(costTime);
		requestLogMQMsgModel.setParamNames(paramNames);
		requestLogMQMsgModel.setParamTypes(paramTypes);
		requestLogMQMsgModel.setParamValues(paramsValues);
		requestLogMQMsgModel.setRemoteAddr(request.getRemoteAddr());
		requestLogMQMsgModel.setRequestURI(request.getRequestURI());
		requestLogMQMsgModel.setRequestMethod(request.getMethod());
		String email = String.valueOf(session.getAttribute("user"));
		requestLogMQMsgModel.setUserEmail(email);
		long now = System.currentTimeMillis();
		String time = DateFormatUtil.format(now);
		requestLogHandler.redisService.lpush("latest-visit", email + "#" + time);
		requestLogHandler.redisService.increby("most-visit", email, 1);
		Set<ZSetOperations.TypedTuple<String>> mostTen = requestLogHandler.redisService.zrank("most-visit", 0, 20);
		List<String> topTen = requestLogHandler.redisService.lrange("latest-visit", 0, 20);
		System.out.println(topTen);
		Map<String, Object> latestMsg = new HashMap<>();
		latestMsg.put("type", "latest");
		latestMsg.put("data", topTen);
		Map<String, Object> mostMsg = new HashMap<>();
		mostMsg.put("type", "most");
		mostMsg.put("data", mostTen);
		try {
			requestLogHandler.websocketService.sendGroupMsg(latestMsg);
			requestLogHandler.websocketService.sendGroupMsg(mostMsg);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (EncodeException e) {
			e.printStackTrace();
		}
		requestLogHandler.activeMQService.sendRequestLog(requestLogMQMsgModel);
	}
}
