package com.sapo.team03.MCRM.Model;

import java.time.LocalDate;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "giaodichkhachang")
public class GiaoDichKhachHang {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column(name= "ngay_giaodich")
	private LocalDate ngayGiaodich;
	@Column(name = "hinh_thuc")
	private String hinhthuc;
	@Column(name = "noi_dung")
	private String noidung;
	@ManyToOne
	@JoinColumn(name = "idkh_giaodichkh")
	
	private Customer customerGD;
	@ManyToOne
	@JoinColumn(name = "idnv_giaodichkh")
	
	private Staff staffGD;
	@Column(name = "trang_thai")
	private int trangthai;
	@Column(name = "chi_phi")
	private Double chiphi;
	
	public GiaoDichKhachHang() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getNgayGiaodich() {
		return ngayGiaodich;
	}

	public void setNgayGiaodich(LocalDate ngayGiaodich) {
		this.ngayGiaodich = ngayGiaodich;
	}

	public String getHinhthuc() {
		return hinhthuc;
	}

	public void setHinhthuc(String hinhthuc) {
		this.hinhthuc = hinhthuc;
	}

	public String getNoidung() {
		return noidung;
	}

	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}

	public Customer getCustomerGD() {
		return customerGD;
	}

	public void setCustomerGD(Customer customerGD) {
		this.customerGD = customerGD;
	}

	public Staff getStaffGD() {
		return staffGD;
	}

	public void setStaffGD(Staff staffGD) {
		this.staffGD = staffGD;
	}

	public int getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}

	public Double getChiphi() {
		return chiphi;
	}

	public void setChiphi(Double chiphi) {
		this.chiphi = chiphi;
	}
	
}
