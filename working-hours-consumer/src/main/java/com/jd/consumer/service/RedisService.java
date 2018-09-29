package com.jd.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
public class RedisService {
	@Autowired
	private RedisTemplate redisTemplate;


	public void setStr(String key, String value) {
		ValueOperations<String, String> vo = redisTemplate.opsForValue();
		vo.set(key, value);
	}

	public String getStr(String key) {
		ValueOperations<String, String> vo = redisTemplate.opsForValue();
		return vo.get(key);
	}

	public void setStr(String key, String value, long expire, TimeUnit timeUnit) {
		ValueOperations<String, String> vo = redisTemplate.opsForValue();
		vo.set(key, value, expire, timeUnit);
	}

	public long getExpire(String key) {
		return redisTemplate.getExpire(key);
	}

	public boolean delKey(String key) {
		return redisTemplate.delete(key);
	}

	public void lpush(String listKey, String value) {
		ListOperations<String, String> lo = redisTemplate.opsForList();
		lo.leftPush(listKey, value);
		lo.trim(listKey, 0, 20);
	}

	public List<String> lrange(String key, long start, long end) {
		ListOperations<String, String> lo = redisTemplate.opsForList();
		return lo.range(key, start, end);
	}

	public void zadd(String key, String value, double score) {
		ZSetOperations zso = redisTemplate.opsForZSet();
		zso.add(key, value, score);
	}

	public Set<ZSetOperations.TypedTuple<String>> zrank(String key, int start, int end) {
		ZSetOperations<String, String> zso = redisTemplate.opsForZSet();
		return zso.reverseRangeWithScores(key, start, end);
	}

	public void increby(String key, String value, double increment) {
		ZSetOperations<String, String> zso = redisTemplate.opsForZSet();
		zso.incrementScore(key, value, increment);
	}


}
