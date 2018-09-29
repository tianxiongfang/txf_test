package com.jd.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jd.provider.mapper")
public class Provider {
	public static void main(String[] args) {
		SpringApplication.run(Provider.class, args);
	}
}
