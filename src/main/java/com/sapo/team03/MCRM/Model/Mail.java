package com.sapo.team03.MCRM.Model;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "mail")
public class Mail {
	@Id
	@GeneratedValue( strategy =GenerationType.AUTO )
	@Column(name = "id")
	private Long id;
	
	@Column(name = "event")
	private String event;
	@Column(name = "content")
	private String content;
	@Column(name = "state")
	private int state;
	@Column(name = "cost")
	private Double cost;
	@Column(name = "time_sent")
	private LocalDate timeSent;
	
	@ManyToOne
	@JoinColumn(name = "id_customer_mail")
	private Customer customerMail;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public LocalDate getTimeSent() {
		return timeSent;
	}

	public void setTimeSent(LocalDate timeSent) {
		this.timeSent = timeSent;
	}

	public Customer getCustomerMail() {
		return customerMail;
	}

	public void setCustomerMail(Customer customerMail) {
		this.customerMail = customerMail;
	}

	public Mail() {
		
	}
}
