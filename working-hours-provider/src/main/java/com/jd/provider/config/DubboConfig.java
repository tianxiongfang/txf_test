package com.jd.provider.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * 加载dubbo的提供者配置文件
 */
@Configuration
@ImportResource(locations = "classpath:dubbo-provider.xml")
public class DubboConfig {
}
