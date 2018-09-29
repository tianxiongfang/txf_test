package com.jd.email.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

@Configuration
public class AuthConfig {

	@Bean
	public Authenticator authenticator(@Value("${mail.sender.name}") String mail,
	                                   @Value("${mail.sender.password}") String password) {
		Authenticator authenticator = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(mail, password);
			}
		};
		return authenticator;
	}
}
