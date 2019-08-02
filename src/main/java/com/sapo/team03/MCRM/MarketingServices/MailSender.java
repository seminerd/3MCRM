package com.sapo.team03.MCRM.MarketingServices;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.core.env.Environment;

public class MailSender implements MessageSender {

	Environment env;

	private Email email;
	Session session;
	Properties mailProp;
	String from;

	@Override
	public void sendEmail() {
		try {

			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getToMail()));
			message.setSubject(email.getSubject());
			message.setText(email.getContent());
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public Environment getEnv() {
		return env;
	}

	public void setEnv(Environment env) {
		this.env = env;
		this.from = env.getProperty("mail.smtp.adminEmail");
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Properties getMailProp() {
		return mailProp;
	}

	public void setMailProp(Properties mailProp) {
		this.mailProp = mailProp;
	}
}
