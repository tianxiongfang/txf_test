package com.jd.email.util;

import com.alibaba.fastjson.JSON;
import com.jd.api.model.RequestLogMQMsgModel;

import java.util.HashMap;
import java.util.Map;

public class EmailBodyWrapperUtil {


	public static Map<String, String> valueMap(RequestLogMQMsgModel requestLogMQMsgModel) {
		String costTime = String.valueOf(requestLogMQMsgModel.getCostTime());
		String methodName = requestLogMQMsgModel.getMethodName();
		String paramNames = JSON.toJSONString(requestLogMQMsgModel.getParamNames());
		String paramTypes = JSON.toJSONString(requestLogMQMsgModel.getParamTypes());
		String paramValues = JSON.toJSONString(requestLogMQMsgModel.getParamValues());
		String remoteAddr = requestLogMQMsgModel.getRemoteAddr();
		String requestMethod = requestLogMQMsgModel.getRequestMethod();
		String requestURI = requestLogMQMsgModel.getRequestURI();
		Map<String, String> valueMap = new HashMap<>();
		valueMap.put("costTime", costTime);
		valueMap.put("methodName", methodName);
		valueMap.put("paramNames", paramNames);
		valueMap.put("paramTypes", paramTypes);
		valueMap.put("paramValues", paramValues);
		valueMap.put("remoteAddr", remoteAddr);
		valueMap.put("requestMethod", requestMethod);
		valueMap.put("requestURI", requestURI);
		return valueMap;

	}

}
