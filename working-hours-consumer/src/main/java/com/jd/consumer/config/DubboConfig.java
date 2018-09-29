package com.jd.consumer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * 加载dubbo消费者配置文件
 */
@Configuration
@ImportResource(locations = "classpath:dubbo-consumer.xml")
public class DubboConfig {
}
