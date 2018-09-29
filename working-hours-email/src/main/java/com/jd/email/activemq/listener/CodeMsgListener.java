package com.jd.email.activemq.listener;

import com.alibaba.fastjson.JSON;
import com.jd.api.model.CodeMQMsgModel;
import com.jd.email.model.EmailModel;
import com.jd.email.service.EmailRenderService;
import com.jd.email.service.EmailService;
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
import java.util.HashMap;
import java.util.Map;

@Component
public class CodeMsgListener implements MessageListener {
	@Autowired
	private EmailService emailService;
	@Autowired
	private EmailRenderService renderService;

	private static final Logger LOGGER = LoggerFactory.getLogger(CodeMsgListener.class);

	@Override
	public void onMessage(Message message) {
		String queueName = "";
		try {
			ActiveMQQueue queue = (ActiveMQQueue) message.getJMSDestination();
			queueName = queue.getQueueName();
		} catch (JMSException e) {
			e.printStackTrace();
		}
		if (message instanceof ObjectMessage) {
			ObjectMessage codeMsg = (ObjectMessage) message;
			try {
				CodeMQMsgModel codeMQMsgModel = (CodeMQMsgModel) codeMsg.getObject();
				LOGGER.info("从队列：" + queueName + " 接收到消息：" + JSON.toJSONString(codeMQMsgModel));
				InternetAddress to = new InternetAddress(codeMQMsgModel.getEmailAddr());
				Map<String, String> codeMap = new HashMap<>();
				codeMap.put("code", codeMQMsgModel.getCode());
				String text = renderService.renderHtml(codeMap, "CodeEmailContent.html");
				EmailModel emailModel = new EmailModel(new InternetAddress[]{to}, "验证码", text);
				emailService.sendEmail(emailModel);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
