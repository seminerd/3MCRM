package com.sapo.team03.MCRM.Model;

//import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "khachhang")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@NotNull
	@Column(name = "ten")
	private String name;
	@Column(name = "email")
	private String mail;
	@Column(name = "dien_thoai")
	private String phoneNumber;
	@Column(name = "nhomkh")
	private String group;
	@Column(name = "gioi_tinh")
	private String gender;
	@Column(name = "ngay_sinh")
	private String dob;
	@Column(name = "cong_no")
	private String debt;
	@Column(name = "dia_chi")
	private String address;
//	@NotNull
//	@ManyToOne
//	@JoinColumn(name = "idnv")
	@Column(name = "idnv")
	private String staffId;
	@Column(name = "ghi_chu")
	private String note;
	@Column(name = "uu_tien")
	@Min(0)
	private Integer priority;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

//	public LocalDate getDob() {
//		return dob;
//	}
//
//	public void setDob(LocalDate dob) {
//		this.dob = dob;
//	}
//
//	public double getDebt() {
//		return debt;
//	}
//
//	public void setDebt(double debt) {
//		this.debt = debt;
//	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
//
//	public Long getStaffId() {
//		return staffId;
//	}
//
//	public void setStaffId(Long staffId) {
//		this.staffId = staffId;
//	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getDebt() {
		return debt;
	}

	public void setDebt(String debt) {
		this.debt = debt;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public Customer(Long id, @NotNull String name, String mail, String phoneNumber, String group, String gender,
			String dob, String debt, String address, String staffId, String note, @Min(0) Integer priority) {
		super();
		this.id = id;
		this.name = name;
		this.mail = mail;
		this.phoneNumber = phoneNumber;
		this.group = group;
		this.gender = gender;
		this.dob = dob;
		this.debt = debt;
		this.address = address;
		this.staffId = staffId;
		this.note = note;
		this.priority = priority;
	}

	public Customer() {
		super();
	}

//	public int getGender() {
//		return gender;
//	}
//
//	public void setGender(int gender) {
//		this.gender = gender;
//	}
	
	

}