package com.sapo.team03.MCRM.Service;

import java.time.LocalDate;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;

import com.sapo.team03.MCRM.DAO.MailDAO;
import com.sapo.team03.MCRM.DAO.MailFormDAO;
import com.sapo.team03.MCRM.DAO.MailReceiverDAO;
import com.sapo.team03.MCRM.Marketing.Model.Email;
import com.sapo.team03.MCRM.Utils.Utilities;

public class MailService {
	@Autowired
	MailDAO mailDAO;
	@Autowired
	Properties prop;
	@Autowired
	MailFormDAO formDAO;
	MailReceiverDAO receiverDAO;
	Session session;

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	void sendMailById(int id) {

	}

	void saveMail() {

	}

	void sendMail(String name ,long formId, String toMail) {
		Email email = new Email();
		email.setForm(formDAO.findById(formId).get());
		email.setFromMail(prop.getProperty("mail.smtp.adminEmail"));
		email.setToMail(toMail);
		try {
			

			Message message = new MimeMessage(session);
//			message.setFrom(new InternetAddress(email.getFromMail()));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getToMail()));
			message.setSubject(email.getForm().getSubject());
			message.setText("Xin chao "+name+", \n"+email.getForm().getContent());

			Transport.send(message);

			Utilities.log(LocalDate.now() + " :: Email sent to: " + email.getToMail());
			mailDAO.save(email);

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

}
