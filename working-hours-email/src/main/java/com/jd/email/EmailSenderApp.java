package com.jd.email;

import freemarker.template.TemplateException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class EmailSenderApp {

	public static void main(String[] args) throws IOException, TemplateException {
		SpringApplication.run(EmailSenderApp.class, args);
	}
}
