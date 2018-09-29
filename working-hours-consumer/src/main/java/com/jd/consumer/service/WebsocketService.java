package com.jd.consumer.service;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@Service
@ServerEndpoint(value = "/websocket")
public class WebsocketService {
	@Autowired
	private RedisService redisService;
	private static WebsocketService websocketService;


	private static volatile int onlineCount = 0;
	private static CopyOnWriteArraySet<WebsocketService> websocketServices = new CopyOnWriteArraySet<>();
	private Session session;

	public WebsocketService() {

	}

	@PostConstruct
	public void init() {
		websocketService = this;
		websocketService.redisService = this.redisService;
	}

	@OnOpen
	public void onOpen(Session session) {
		this.session = session;
		websocketServices.add(this);
	}

	@OnClose
	public void onClose() {
		websocketServices.remove(this);
		onlineCount--;
	}

	@OnMessage
	public void onMessage(String message, Session session) {
		List<String> topTen = websocketService.redisService.lrange("latest-visit", 0, 20);
		System.out.println(topTen);
		Map<String, Object> latestMsg = new HashMap<>();
		latestMsg.put("type", "latest");
		latestMsg.put("data", topTen);

		Set<ZSetOperations.TypedTuple<String>> mostTen = websocketService.redisService.zrank("most-visit", 0, 20);
		Map<String, Object> mostMsg = new HashMap<>();
		mostMsg.put("type", "most");
		mostMsg.put("data", mostTen);

		try {
			sendGroupMsg(latestMsg);
			sendGroupMsg(mostMsg);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (EncodeException e) {
			e.printStackTrace();
		}
	}

	public void sendMessage(Object message) throws IOException, EncodeException {
		this.session.getBasicRemote().sendText(JSON.toJSONString(message));
	}

	public void sendGroupMsg(Object message) throws IOException, EncodeException {

		for (WebsocketService websocketService : websocketServices) {
			websocketService.sendMessage(message);
		}
	}


}
