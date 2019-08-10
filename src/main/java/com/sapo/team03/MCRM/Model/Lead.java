package com.sapo.team03.MCRM.Model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "lead")
public class Lead {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	@Column(name = "name")
	private String name;
	@Column(name = "email")
	private String email;
	@Column(name = "phone")
	private String phone;
	@ManyToMany
	@JoinTable(name = "lead_category", 
	joinColumns = @JoinColumn(name = "id_lead"), 
	inverseJoinColumns = @JoinColumn(name = "id_category"))
	private Set<CategoryProduct> interest;
	@Column(name = "state")
	private String state;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Set<CategoryProduct> getInterest() {
		return interest;
	}
	public void setInterest(Set<CategoryProduct> interest) {
		this.interest = interest;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	

}
