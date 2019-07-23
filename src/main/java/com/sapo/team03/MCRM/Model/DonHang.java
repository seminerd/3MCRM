package com.sapo.team03.MCRM.Model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "donhang")
public class DonHang {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column(name = "ngay_dathang")
	private LocalDate ngayDatHang;
	@Column(name = "diachi_giaohang")
	private String diachiGiaohang;
	@Column(name = "tong_tien")
	private Double tongTien;
	
	@ManyToOne
	
	@JoinColumn(name = "idnv_dh")
	private Staff staffDH;
	
	@ManyToOne()
	
	@JoinColumn(name = "idk_dh")
	private Customer customerDH;
	
	@OneToMany(mappedBy = "ctDonHang")
	private Set<CTDonHang> ctDonHang;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getNgayDatHang() {
		return ngayDatHang;
	}

	public void setNgayDatHang(LocalDate ngayDatHang) {
		this.ngayDatHang = ngayDatHang;
	}

	public String getDiachiGiaohang() {
		return diachiGiaohang;
	}

	public void setDiachiGiaohang(String diachiGiaohang) {
		this.diachiGiaohang = diachiGiaohang;
	}

	public Double getTongTien() {
		return tongTien;
	}

	public void setTongTien(Double tongTien) {
		this.tongTien = tongTien;
	}

	public Customer getCustomerDH() {
		return customerDH;
	}

	public void setCustomerDH(Customer customerDH) {
		this.customerDH = customerDH;
	}

	public Staff getStaffDH() {
		return staffDH;
	}

	public void setStaffDH(Staff staffDH) {
		this.staffDH = staffDH;
	}

	public Set<CTDonHang> getCtDonHang() {
		return ctDonHang;
	}

	public void setCtDonHang(Set<CTDonHang> ctDonHang) {
		this.ctDonHang = ctDonHang;
	}
	public DonHang() {
		
	}
}
