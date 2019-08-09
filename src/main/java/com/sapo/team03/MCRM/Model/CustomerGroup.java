package com.sapo.team03.MCRM.Model;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name= "customer_group")
public class CustomerGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "default_price")
	private Double defaultPrice;
	@Column(name = "default_tax")
	private Double defaultTax;
	@Column(name = "discount")
	private Double discount;
	@Column(name = "note")
	private String note;
	@JsonBackReference("n")
	@OneToMany(mappedBy = "group")
	private Set<Customer> customers;
	@Column(name = "update_date")
	private Date updateDate;
	public CustomerGroup() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

	public Double getDefaultPrice() {
		return defaultPrice;
	}

	public void setDefaultPrice(Double defaultPrice) {
		this.defaultPrice = defaultPrice;
	}

	public Double getDefaultTax() {
		return defaultTax;
	}

	public void setDefaultTax(Double defaultTax) {
		this.defaultTax = defaultTax;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
}
