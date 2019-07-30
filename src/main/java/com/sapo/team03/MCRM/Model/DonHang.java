package com.sapo.team03.MCRM.Model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "donhang")
public class DonHang {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column(name = "ngay_dathang")
	private Date ngay_dathang;
	@Column(name = "diachi_giaohang")
	private String diachi_giaohang;
	@Column(name = "tong_tien")
	private Double tong_tien;
	@ManyToOne
	@JoinColumn(name = "idnv_dh")
	private Staff staffDH;
	@ManyToOne
	@JoinColumn(name = "idkh_dh")
	private Customer customerDH;
	@JsonBackReference("s")
	@OneToMany(mappedBy = "ctDonHang",fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
	@ElementCollection
	private Set<CTDonHang> ctDonhang;
	@Column(name = "phuongthuc_thanhtoan")
	private String phuongthuc_thanhtoan;
	@Column(name = "trangthai")
	private Integer trangthai;
	@Column(name = "ngay_giaohang")
	private Date ngay_giaohang;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public Date getNgay_dathang() {
		return ngay_dathang;
	}

	public void setNgay_dathang(Date ngay_dathang) {
		this.ngay_dathang = ngay_dathang;
	}

	public String getDiachi_giaohang() {
		return diachi_giaohang;
	}
//
//	public LocalDate getNgay_dathang() {
//		return ngay_dathang;
//	}

//	public void setNgay_dathang(LocalDate ngay_dathang) {
//		this.ngay_dathang = ngay_dathang;
//	}

	public void setDiachi_giaohang(String diachi_giaohang) {
		this.diachi_giaohang = diachi_giaohang;
	}

	public Double getTong_tien() {
		return tong_tien;
	}

	public void setTong_tien(Double tong_tien) {
		this.tong_tien = tong_tien;
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


	public Set<CTDonHang> getCtDonhang() {
		return ctDonhang;
	}

	public void setCtDonhang(Set<CTDonHang> ctDonhang) {
		this.ctDonhang = ctDonhang;
	}

	public String getPhuongthuc_thanhtoan() {
		return phuongthuc_thanhtoan;
	}

	public void setPhuongthuc_thanhtoan(String phuongthuc_thanhtoan) {
		this.phuongthuc_thanhtoan = phuongthuc_thanhtoan;
	}


	public Integer getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(Integer trangthai) {
		this.trangthai = trangthai;
	}

	public Date getNgay_giaohang() {
		return ngay_giaohang;
	}

	public void setNgay_giaohang(Date ngay_giaohang) {
		this.ngay_giaohang = ngay_giaohang;
	}

	public DonHang() {
		
	}
}
