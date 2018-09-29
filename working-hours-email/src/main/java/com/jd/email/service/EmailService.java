package com.jd.email.service;

import com.jd.email.config.EmailConfig;
import com.jd.email.model.EmailModel;
import com.sun.mail.util.MailSSLSocketFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.validation.constraints.Email;
import java.security.GeneralSecurityException;
import java.util.Properties;

@Service
public class EmailService {
	@Autowired
	private Authenticator authenticator;
	@Autowired
	private EmailConfig emailConfig;

	private static final Logger LOGGER = LoggerFactory.getLogger(Email.class);

	private Properties getOutlookPros() throws GeneralSecurityException {
		Properties pros = new Properties();
		pros.put("mail.smtp.host", emailConfig.getSmtpHost());
		pros.put("mail.smtp.port", emailConfig.getSmtpPort());
		pros.put("mail.smtp.auth", emailConfig.getSmtpAuth());
		pros.put("mail.smtp.starttls.enable", emailConfig.getTlsEnable());
		pros.put("mail.smtp.ssl.enable", emailConfig.getSslEnable());
		pros.put("mail.smtp.ssl.checkserveridentity", emailConfig.getCheckServerIdentity());
		MailSSLSocketFactory mailSSLSocketFactory = new MailSSLSocketFactory();
		mailSSLSocketFactory.setTrustAllHosts(true);
		pros.put("mail.smtp.ssl.socketFactory", mailSSLSocketFactory);
		return pros;
	}

	private Message wrapMessage(Session session, EmailModel emailModel) throws MessagingException {
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(emailConfig.getSendFrom()));
		message.setRecipients(Message.RecipientType.TO, emailModel.getTo());
		message.setSubject(emailModel.getSubject());
		message.setContent(emailModel.getText(), "text/html;charset=utf-8");
		return message;
	}

	public boolean sendEmail(EmailModel emailModel) {
		Properties properties = null;
		try {
			properties = getOutlookPros();
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
			return false;
		}
		Session session = Session.getInstance(properties, authenticator);
		Message message = null;
		try {
			message = wrapMessage(session, emailModel);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		try {
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
		LOGGER.info("已发送邮件至:" + emailModel.getTo()[0].getAddress());
		return true;
	}
}
