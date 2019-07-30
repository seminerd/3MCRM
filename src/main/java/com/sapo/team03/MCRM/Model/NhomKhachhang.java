package com.sapo.team03.MCRM.Model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "nhomkhachhang")
public class NhomKhachhang {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column(name = "ten")
	private String ten;
	@Column(name = "gia_macdinh")
	private Double giaMacdinh;
	@Column(name = "thue_macdinh")
	private Double thueMacdinh;
	@Column(name = "chiet_khau")
	private Double chietkhau;
	@Column(name = "ghi_chu")
	private String ghichu;
	@JsonBackReference("n")
	@OneToMany(mappedBy = "nhomkhachhang")
	private Set<Customer> customers;
	
	public NhomKhachhang() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public Double getGiaMacdinh() {
		return giaMacdinh;
	}

	public void setGiaMacdinh(Double giaMacdinh) {
		this.giaMacdinh = giaMacdinh;
	}

	public Double getThueMacdinh() {
		return thueMacdinh;
	}

	public void setThueMacdinh(Double thueMacdinh) {
		this.thueMacdinh = thueMacdinh;
	}

	public Double getChietkhau() {
		return chietkhau;
	}

	public void setChietkhau(Double chietkhau) {
		this.chietkhau = chietkhau;
	}

	public String getGhichu() {
		return ghichu;
	}

	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}

	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}
	
}
