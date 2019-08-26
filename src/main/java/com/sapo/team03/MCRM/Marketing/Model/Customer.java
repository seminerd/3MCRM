package com.sapo.team03.MCRM.Marketing.Model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sapo.team03.MCRM.Management.Model.Staff;
import com.sapo.team03.MCRM.Sale.Model.CustomerTransaction;
import com.sapo.team03.MCRM.Sale.Model.Orders;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "email")
	private String email;
	@Column(name = "phone")
	@Size(max = 20)
	private String phone;
	@Column(name = "gender")
	private Integer gender;
	@Column(name = "dob")
	private Date dob;
	@Column(name = "debt")
	private Double debt;
	@Column(name = "address")
	private String address;
	@ManyToOne
	@JoinColumn(name = "staff_id")
	private Staff staff;
	@Column(name = "note")
	private String note;
	@JsonBackReference("a")
	@OneToMany(mappedBy = "customerOrder")
	private List<Orders> orders;
	@JsonBackReference("b")
	@OneToMany(mappedBy = "customerTransaction")
	private Set<CustomerTransaction> transactions;
	
	@ManyToMany
	@JoinTable(name = "cus_group", joinColumns = @JoinColumn(name = "id_cus"),
								   inverseJoinColumns = @JoinColumn(name = "id_group"))
	private List<CustomerGroup> groups;
	
	@Column(name = "update_date")
	private Date updateDate;
	@Column(name = "points")
	private Integer point;
	
	public Customer() {
		super();
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

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Double getDebt() {
		return debt;
	}

	public void setDebt(Double debt) {
		this.debt = debt;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phoneNumber) {
		this.phone = phoneNumber;
	}

//	public Set<Mail> getMail() {
//		return mail;
//	}
//
//	public void setMail(Set<Mail> mail) {
//		this.mail = mail;
//	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public Set<CustomerTransaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<CustomerTransaction> transactions) {
		this.transactions = transactions;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public List<CustomerGroup> getGroups() {
		return groups;
	}

	public void setGroups(List<CustomerGroup> groups) {
		this.groups = groups;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public void setId(Long id) {
		this.id = id;
	}

}