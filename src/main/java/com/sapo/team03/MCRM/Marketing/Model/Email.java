package com.sapo.team03.MCRM.Marketing.Model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mail")
public class Email {

	public Email() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	@Column(name = "time_sent")
	private LocalDate timeSent;
	@Column(name = "to_mail")
	private String toMail;
	@Column(name = "from_mail")
	private String fromMail;
	@ManyToOne
	@JoinColumn(name = "mail_form_id")
	private MailForm form;

	public MailForm getForm() {
		return form;
	}

	public void setForm(MailForm form) {
		this.form = form;
	}

	public String getFromMail() {
		return fromMail;
	}

	public void setFromMail(String fromMail) {
		this.fromMail = fromMail;
	}

	public LocalDate getTimeSent() {
		return timeSent;
	}

	public void setTimeSent(LocalDate timeSent) {
		this.timeSent = timeSent;
	}

	public String getToMail() {
		return toMail;
	}

	public void setToMail(String toMail) {
		this.toMail = toMail;
	}

}
