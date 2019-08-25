package com.sapo.team03.MCRM.Marketing.Model;

import java.util.Date;
import java.util.List;
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
	@ManyToMany(mappedBy = "groups")
	private List<Customer> customers;
	@Column(name = "update_date")
	private Date updateDate;
	@Column(name = "id_group")
	private int idGroup;
	@Column(name = "quantity")
	private int quantity;
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

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
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

	public int getIdGroup() {
		return idGroup;
	}

	public void setIdGroup(int idGroup) {
		this.idGroup = idGroup;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean checkExistingGroup(List<CustomerGroup> list) {
		for (CustomerGroup temp : list) {
			if(temp.getId()==this.getId()) return true;
		}
		return false;
	}
	
}
