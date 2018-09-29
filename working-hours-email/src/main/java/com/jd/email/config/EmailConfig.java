package com.jd.email.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmailConfig {
	@Value("${mail.smtp.host}")
	private String smtpHost;
	@Value("${mail.smtp.port}")
	private String smtpPort;
	@Value("${mail.smtp.auth}")
	private String smtpAuth;
	@Value("${mail.smtp.starttls.enable}")
	private String tlsEnable;
	@Value("${mail.smtp.ssl.enable}")
	private String sslEnable;
	@Value("${mail.smtp.ssl.checkserveridentity}")
	private String checkServerIdentity;
	@Value("${mail.sender.name}")
	private String sendFrom;

	public String getSmtpHost() {
		return smtpHost;
	}

	public void setSmtpHost(String smtpHost) {
		this.smtpHost = smtpHost;
	}

	public String getSmtpPort() {
		return smtpPort;
	}

	public void setSmtpPort(String smtpPort) {
		this.smtpPort = smtpPort;
	}

	public String getSmtpAuth() {
		return smtpAuth;
	}

	public void setSmtpAuth(String smtpAuth) {
		this.smtpAuth = smtpAuth;
	}

	public String getTlsEnable() {
		return tlsEnable;
	}

	public void setTlsEnable(String tlsEnable) {
		this.tlsEnable = tlsEnable;
	}

	public String getSslEnable() {
		return sslEnable;
	}

	public void setSslEnable(String sslEnable) {
		this.sslEnable = sslEnable;
	}

	public String getCheckServerIdentity() {
		return checkServerIdentity;
	}

	public void setCheckServerIdentity(String checkServerIdentity) {
		this.checkServerIdentity = checkServerIdentity;
	}

	public String getSendFrom() {
		return sendFrom;
	}

	public void setSendFrom(String sendFrom) {
		this.sendFrom = sendFrom;
	}
}
