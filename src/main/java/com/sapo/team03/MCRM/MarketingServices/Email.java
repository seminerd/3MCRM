package com.sapo.team03.MCRM.MarketingServices;

public class Email {

	public Email() {
		
	}
	
	private String subject;
	String content;
	private String toMail;
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getToMail() {
		return toMail;
	}
	public void setToMail(String toMail) {
		this.toMail = toMail;
	}
	public String getContent() {
		// TODO Auto-generated method stub
		return this.content;
	}
	

}
