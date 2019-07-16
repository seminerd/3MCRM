package com.sapo.team03.MCRM.Model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "khachhang")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column(name = "ten")
	private String name;
	@Column(name = "email")
	private String email;
	@Column(name = "dien_thoai")
	@Size(max = 12)
	private String phoneNumber;
	@Column(name = "nhomkh")
	private String group;
	@Column(name = "gioi_tinh")
	private Integer gender;
	@Column(name = "ngay_sinh")
	private LocalDate dob;
	@Column(name = "cong_no")
	private Double debt;
	@Column(name = "dia_chi")
	private String address;

	// foreign key
	@ManyToOne
	@JoinColumn(name = "idnv_kh")
	private Staff staff;

	@Column(name = "ghi_chu")
	private String note;
	@Column(name = "uu_tien")
	private Integer priority;

	@OneToOne(mappedBy = "customerMail")
	private Mail mail;

	@JsonBackReference("a")
	@OneToMany(mappedBy = "customerDH")
	private Set<DonHang> donhang;

	@JsonBackReference("b")
	@OneToMany(mappedBy = "customerGD")
	private Set<GiaoDichKhachHang> gdkh;

	public Customer() {
		super();
	}

	public Customer(String name, String email, @Size(max = 12) String phoneNumber, String group, Integer gender,
			LocalDate dob, Double debt, String address, Staff staff, String note, Integer priority) {
		super();

		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.group = group;
		this.gender = gender;
		this.dob = dob;
		this.debt = debt;
		this.address = address;
		this.staff = staff;
		this.note = note;
		this.priority = priority;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
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

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		return true;
	}

	public Mail getMail() {
		return mail;
	}

	public void setMail(Mail mail) {
		this.mail = mail;
	}

	public Set<DonHang> getDonhang() {
		return donhang;
	}

	public void setDonhang(Set<DonHang> donhang) {
		this.donhang = donhang;
	}

	public Set<GiaoDichKhachHang> getGdkh() {
		return gdkh;
	}

	public void setGdkh(Set<GiaoDichKhachHang> gdkh) {
		this.gdkh = gdkh;
	}

}