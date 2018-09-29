package com.jd.email.model;


import javax.mail.internet.InternetAddress;
import java.io.Serializable;

public class EmailModel implements Serializable {
	private InternetAddress[] to;
	private String subject;
	private String text;


	public EmailModel(){

	}

	public EmailModel(InternetAddress[] to, String subject, String text) {
		this.to = to;
		this.subject = subject;
		this.text = text;
	}

	public InternetAddress[] getTo() {
		return to;
	}

	public void setTo(InternetAddress[] to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
