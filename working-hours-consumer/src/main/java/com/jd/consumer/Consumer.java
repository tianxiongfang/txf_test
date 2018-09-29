package com.jd.consumer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
@MapperScan("com.jd.consumer.mapper")
public class Consumer {
	public static void main(String[] args) {
		SpringApplication.run(Consumer.class, args);
	}
}
