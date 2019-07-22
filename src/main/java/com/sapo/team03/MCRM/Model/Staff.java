package com.sapo.team03.MCRM.Model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
	@Column(name = "ngay_sinh")
	private LocalDate dob;
	@Column(name = "dien_thoai")
	private String phoneNumber;
	@Column(name = "password")
	private String password;
	@Column(name = "chuc_vu")
	private String role;
	@Column(name = "gioi_tinh")
	private Integer gender;
	@Column(name = "mo_ta")
	private String note;
	@Column(name = "role")
	private Integer roleUA;
	@OneToMany(mappedBy = "staff", cascade=CascadeType.ALL)
	@JsonBackReference("c")
	private Set<Customer> customers;

	@JsonBackReference("d")
	@OneToMany(mappedBy = "staffDH")
	private Set<DonHang> donhang;

	@JsonBackReference("e")
	@OneToMany(mappedBy = "staffGD")
	private Set<GiaoDichKhachHang> gdkh;

	public Staff(Long id, String name, String email, LocalDate dob, String phoneNumber, String password, String role,
			int gender, String note, Set<Customer> customers) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.role = role;
		this.gender = gender;
		this.note = note;
		this.customers = customers;
	}

	public Staff() {

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

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
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
		Staff other = (Staff) obj;
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

	public Integer getRoleUA() {
		return roleUA;
	}

	public void setRoleUA(Integer roleUA) {
		this.roleUA = roleUA;
	}
	
	

}