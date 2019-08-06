package com.sapo.team03.MCRM.Model;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "transaction_customer")
public class CustomerTransaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column(name= "date_transaction")
	private LocalDate dateTransaction;
	@Column(name = "form")
	private String form;
	@Column(name = "content")
	private String content;
	@ManyToOne
	@JoinColumn(name = "id_customer_transaction")
	private Customer customerTransaction;
	@ManyToOne
	@JoinColumn(name = "id_staff_transaction")
	private Staff staffTransaction;
	@Column(name = "state")
	private int state;
	@Column(name = "cost")
	private Double cost;
	
	public CustomerTransaction() {
		
	}

	public LocalDate getDateTransaction() {
		return dateTransaction;
	}

	public void setDateTransaction(LocalDate dateTransaction) {
		this.dateTransaction = dateTransaction;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Customer getCustomerTransaction() {
		return customerTransaction;
	}

	public void setCustomerTransaction(Customer customerTransaction) {
		this.customerTransaction = customerTransaction;
	}

	public Staff getStaffTransaction() {
		return staffTransaction;
	}

	public void setStaffTransaction(Staff staffTransaction) {
		this.staffTransaction = staffTransaction;
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

	public Long getId() {
		return id;
	}
	
}
