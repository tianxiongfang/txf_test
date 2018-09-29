package com.jd.email.activemq.config;

import com.jd.email.activemq.listener.CodeMsgListener;
import com.jd.email.activemq.listener.LogMsgListener;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.listener.MessageListenerContainer;
import org.springframework.jms.listener.SimpleMessageListenerContainer;

import javax.jms.ConnectionFactory;

@Configuration
public class ActiveMQConfig {
	@Bean(value = "amqCf")
	public ActiveMQConnectionFactory activeMQConnectionFactory(@Value("${consumer.activemq.brokerurl}") String brokerUrl) {
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(brokerUrl);
		activeMQConnectionFactory.setTrustAllPackages(true);
		return activeMQConnectionFactory;
	}

	@Bean(value = "cacheCf")
	public ConnectionFactory connectionFactory(@Autowired @Qualifier("amqCf") ConnectionFactory connectionFactory) {
		CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(connectionFactory);
		return cachingConnectionFactory;
	}

	@Bean(value = "logMLC")
	public MessageListenerContainer logMessageListenerContainer(@Autowired LogMsgListener logMsgListener,
	                                                            @Autowired @Qualifier("cacheCf") ConnectionFactory connectionFactory,
	                                                            @Value("${info.queue.name}") String queueName) {
		SimpleMessageListenerContainer messageListenerContainer = new SimpleMessageListenerContainer();
		messageListenerContainer.setConnectionFactory(connectionFactory);
		messageListenerContainer.setDestinationName(queueName);
		messageListenerContainer.setMessageListener(logMsgListener);
		return messageListenerContainer;
	}


	@Bean(value = "codeMLC")
	public MessageListenerContainer codeMessageListenerContainer(@Autowired CodeMsgListener codeMsgListener,
	                                                             @Autowired @Qualifier("cacheCf") ConnectionFactory connectionFactory,
	                                                             @Value("${code.queue.name}") String queueName) {
		SimpleMessageListenerContainer messageListenerContainer = new SimpleMessageListenerContainer();
		messageListenerContainer.setConnectionFactory(connectionFactory);
		messageListenerContainer.setDestinationName(queueName);
		messageListenerContainer.setMessageListener(codeMsgListener);
		return messageListenerContainer;

	}


	@Bean
	public JmsListenerContainerFactory jmsListenerContainerFactory(@Autowired @Qualifier("cacheCf") CachingConnectionFactory connectionFactory) {
		DefaultJmsListenerContainerFactory jmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
		jmsListenerContainerFactory.setConnectionFactory(connectionFactory);
		return jmsListenerContainerFactory;
	}


}
