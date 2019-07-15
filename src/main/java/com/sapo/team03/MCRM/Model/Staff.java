package com.sapo.team03.MCRM.Model;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "nhanvien")
public class Staff {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column(name = "ten")
	private String name;
	@Column(name = "email")
	private String email;
	@Column(name = "dia_chi")
	private String address;
	@Column(name = "ngay_sinh")
	private LocalDate dob;
	@Column(name = "password")
	private String password;
	@Column(name = "chuc_vu")
	private String role;
	@Column(name = "gioi_tinh")
	private int gender;
	@Column(name = "mo_ta")
	private String note;
//	private List<Customer> customers;
	

	public String getName() {
		return name;
	}
	public Staff() {
	super();
}
	public Staff(Long id, String name, String email, String address, LocalDate dob, String password, String role,
			int gender, String note) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.dob = dob;
		this.password = password;
		this.role = role;
		this.gender = gender;
		this.note = note;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
}