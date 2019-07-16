package com.sapo.team03.MCRM.Model;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "mail")
public class Mail {
	@Id
	@GeneratedValue( strategy =GenerationType.AUTO )
	@Column(name = "id")
	private Long id;
	
	@Column(name = "su_kien")
	private String suKien;
	@Column(name = "noi_dung")
	private String noiDung;
	@Column(name = "trang_thai")
	private int trangThai;
	@Column(name = "chi_phi")
	private Double chiPhi;
	@Column(name = "thoigian_gui")
	private LocalDate thoigianGui;
	
	@OneToOne
	@JoinColumn(name = "idkh_mail")
	private Customer customerMail;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSuKien() {
		return suKien;
	}
	public void setSuKien(String suKien) {
		this.suKien = suKien;
	}
	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	public int getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}
	public Double getChiPhi() {
		return chiPhi;
	}
	public void setChiPhi(Double chiPhi) {
		this.chiPhi = chiPhi;
	}
	public LocalDate getThoigianGui() {
		return thoigianGui;
	}
	public void setThoigianGui(LocalDate thoigianGui) {
		this.thoigianGui = thoigianGui;
	}
	public Customer getCustomerMail() {
		return customerMail;
	}
	public void setCustomer(Customer customer) {
		this.customerMail = customer;
	}
	public Mail(Long id, String suKien, String noiDung, int trangThai, Double chiPhi, LocalDate thoigianGui,
			Customer customer) {
		super();
		this.id = id;
		this.suKien = suKien;
		this.noiDung = noiDung;
		this.trangThai = trangThai;
		this.chiPhi = chiPhi;
		this.thoigianGui = thoigianGui;
		this.customerMail = customer;
	}
	
	public Mail() {
		
	}
}
