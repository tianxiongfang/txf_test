package com.jd.provider.util;

import com.alibaba.fastjson.JSON;

public class JSONUtil {
	public static String getJSONString(Object o) {
		return JSON.toJSONString(o);
	}

	public static <T> T getObjectFromJSON(String json, Class<T> cls) {
		T t = JSON.parseObject(json, cls);
		return t;
	}

}
