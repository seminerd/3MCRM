package com.sapo.team03.MCRM.Config;

import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

import com.sapo.team03.MCRM.Service.MailService;

@Configuration
public class MailConfig {
	@Autowired
	Environment env;

	@Bean("prop")
	@Scope("singleton")
	@ConfigurationProperties(prefix = "mail.smtp")
	@Primary
	Properties getProp() {
		Properties prop = new Properties();
		prop.put("mail.smtp.host", env.getProperty("mail.smtp.host"));
		prop.put("mail.smtp.port", env.getProperty("mail.smtp.port"));
		prop.put("mail.smtp.auth", env.getProperty("mail.smtp.auth"));
		prop.put("mail.smtp.starttls.enable", env.getProperty("mail.smtp.starttls.enable"));
		prop.put("mail.smtp.ssl.trust",env.getProperty("mail.smtp.ssl.trust"));
		prop.put("mail.smtp.socketFactory.port",env.getProperty("mail.smtp.socketFactory.port"));
		prop.put("mail.smtp.adminEmail",env.getProperty("mail.smtp.adminEmail"));
		prop.put("mail.smtp.adminPassword",env.getProperty("mail.smtp.adminPassword"));
		
		
		return prop;

	}
//	@Bean(name="accountProp")
//	@Scope("singleton")
//	@ConfigurationProperties(prefix = "mail.smtp")
//	Properties getAccountProp() {
//		Properties prop = new Properties();
//		prop.put("mail.smtp.adminEmail",env.getProperty("mail.smtp.adminEmail"));
//		prop.put("mail.smtp.adminPassword",env.getProperty("mail.smtp.adminPassword"));
//		return prop;
//	}

	@Bean
	@ConfigurationProperties(prefix = "mail.smtp")
	@Primary
	@Scope("singleton")
	Session getSession() {
		Session session = Session.getInstance(getProp(), new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(env.getProperty("mail.smtp.adminEmail"), env.getProperty("mail.smtp.adminPassword"));
			}
		});
		return session;

	}
	@Bean(name="mailService")
	@ConfigurationProperties(prefix = "mail.smtp")
	@Primary
	@Scope("singleton")
	MailService getMailService() {
		MailService service = new MailService();
		service.setSession(getSession());
		return service;
	}

//	@Bean
//	@Scope("prototype")
//	MailSender getMailSender() {
//		MailSender mailSender = new MailSender();
//		mailSender.setEnv(env);
//		mailSender.setMailProp(getProp());
//		mailSender.setSession(getSession());
//		return mailSender;

//	}

}
