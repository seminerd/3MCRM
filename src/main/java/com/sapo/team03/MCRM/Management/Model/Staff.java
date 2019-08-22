package com.sapo.team03.MCRM.Management.Model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sapo.team03.MCRM.Marketing.Model.Customer;
import com.sapo.team03.MCRM.Sale.Model.CustomerTransaction;
import com.sapo.team03.MCRM.Sale.Model.Orders;

@Entity
@Table(name = "staff")
public class Staff {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "email")
	private String email;
	@Column(name = "dob")
	private LocalDate dob;
	@Column(name = "phone")
	private String phone;
	@Column(name = "password")
	private String password;
	@Column(name = "job_title")
	private String jobTitle;
	@Column(name = "gender")
	private Integer gender;
	@Column(name = "description")
	private String description;
	@Column(name = "role")
	private Integer role;
	@OneToMany(mappedBy = "staff")
	@JsonBackReference("c")
	private List<Customer> customers;
	@JsonBackReference("d")
	@OneToMany(mappedBy = "staffOrder")
	private Set<Orders> orders;
	@JsonBackReference("e")
	@OneToMany(mappedBy = "staffTransaction")
	private Set<CustomerTransaction> transactions;
	@Column(name = "update_date")
	private Date updateDate;
	
	public Staff() {
		
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phoneNumber) {
		this.phone = phoneNumber;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Staff(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public Set<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}

	public Set<CustomerTransaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<CustomerTransaction> transactions) {
		this.transactions = transactions;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
}