package com.jd.consumer.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;


@Configuration
public class ActiveMQConfig {
	@Bean(value = "amqCf")
	public ActiveMQConnectionFactory activeMQConnectionFactory(@Value("${producer.activemq.brokerurl}") String brokerUrl) {
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(brokerUrl);
		activeMQConnectionFactory.setUseAsyncSend(true);
		return activeMQConnectionFactory;
	}

	@Bean(value = "cacheCf")
	public CachingConnectionFactory cachingConnectionFactory(@Autowired @Qualifier("amqCf") ActiveMQConnectionFactory activeMQConnectionFactory) {
		CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(activeMQConnectionFactory);
		return cachingConnectionFactory;
	}

	@Bean(value = "apiLogQueue")
	public ActiveMQQueue defaultDestination(@Value("${info.queue.name}") String name) {
		ActiveMQQueue activeMQQueue = new ActiveMQQueue(name);
		return activeMQQueue;
	}

	@Bean(value = "codeQueue")
	public ActiveMQQueue codeQueue(@Value("${code.queue.name}") String name) {
		return new ActiveMQQueue(name);
	}

	@Bean
	public JmsTemplate jmsTemplate(@Autowired @Qualifier("cacheCf") CachingConnectionFactory connectionFactory, @Autowired @Qualifier("apiLogQueue") ActiveMQQueue defaultDest) {
		JmsTemplate jmsTemplate = new JmsTemplate();
		jmsTemplate.setConnectionFactory(connectionFactory);
		jmsTemplate.setDefaultDestination(defaultDest);
		return jmsTemplate;
	}

	@Bean
	public JmsListenerContainerFactory jmsListenerContainerFactory(@Autowired @Qualifier("cacheCf") CachingConnectionFactory connectionFactory) {
		DefaultJmsListenerContainerFactory jmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
		jmsListenerContainerFactory.setConnectionFactory(connectionFactory);
		return jmsListenerContainerFactory;
	}

}


