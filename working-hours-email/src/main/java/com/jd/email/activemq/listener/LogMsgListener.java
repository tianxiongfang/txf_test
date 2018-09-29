package com.jd.email.activemq.listener;

import com.alibaba.fastjson.JSON;
import com.jd.api.model.RequestLogMQMsgModel;
import com.jd.email.model.EmailModel;
import com.jd.email.service.EmailRenderService;
import com.jd.email.service.EmailService;
import com.jd.email.util.EmailBodyWrapperUtil;
import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.mail.internet.InternetAddress;
import java.util.Map;

@Component
public class LogMsgListener implements MessageListener {
	@Autowired
	private EmailService emailService;
	@Autowired
	private EmailRenderService renderService;
	private static final Logger LOGGER = LoggerFactory.getLogger(LogMsgListener.class);

	@Override
	public void onMessage(Message message) {
		String queueName = "";
		try {
			ActiveMQQueue activeMQQueue = (ActiveMQQueue) message.getJMSDestination();
			queueName = activeMQQueue.getQueueName();
		} catch (JMSException e) {
			e.printStackTrace();
		}
		if (message instanceof ObjectMessage) {
			ObjectMessage objectMessage = (ObjectMessage) message;
			try {
				RequestLogMQMsgModel logModel = (RequestLogMQMsgModel) objectMessage.getObject();
				Map<String, String> valueMap = EmailBodyWrapperUtil.valueMap(logModel);
				LOGGER.info("从队列：" + queueName + " 接收到消息：" + JSON.toJSONString(logModel));
				String text = renderService.renderHtml(valueMap, "LogEmailContent.html");
				String subject = "API调用日志";
				InternetAddress to = new InternetAddress(logModel.getUserEmail());
				EmailModel emailModel = new EmailModel(new InternetAddress[]{to}, subject, text);
				emailService.sendEmail(emailModel);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
