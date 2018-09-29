package com.jd.consumer.service;

import com.alibaba.fastjson.JSON;
import com.jd.api.model.CodeMQMsgModel;
import com.jd.api.model.RequestLogMQMsgModel;
import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@Service
public class ActiveMQService {
	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	@Qualifier("codeQueue")
	private Destination codeDest;

	private static final Logger LOGGER = LoggerFactory.getLogger(ActiveMQService.class);

	public void sendRequestLog(RequestLogMQMsgModel logModel) {
		MessageCreator objMsg = new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createObjectMessage(logModel);
			}
		};
		jmsTemplate.send(objMsg);
		LOGGER.info("向队列:info-queue发送mq消息：" + JSON.toJSONString(logModel));
	}

	public void sendCode(CodeMQMsgModel codeMQMsgModel) {
		MessageCreator objMsg = new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createObjectMessage(codeMQMsgModel);
			}
		};
		jmsTemplate.send(codeDest, objMsg);
		try {
			LOGGER.info("向队列:" + ((ActiveMQQueue) codeDest).getQueueName() + "发送mq消息：" + JSON.toJSONString(codeMQMsgModel));
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
