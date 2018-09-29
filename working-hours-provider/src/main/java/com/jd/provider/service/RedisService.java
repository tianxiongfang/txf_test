package com.jd.provider.service;

import com.jd.provider.util.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisService {
	@Autowired
	private RedisTemplate redisTemplate;

	public void setObject(String key, Object o, long eprTime, TimeUnit unit) {
		String value = JSONUtil.getJSONString(o);
		ValueOperations<String, String> vo = redisTemplate.opsForValue();
		vo.set(key, value, 3600, unit);
	}

	public <T> T getObject(String key, Class<T> cls) {
		ValueOperations<String, String> vo = redisTemplate.opsForValue();
		String value = vo.get(key);
		if (value == null) {
			return null;
		}
		return JSONUtil.getObjectFromJSON(value, cls);
	}

}
