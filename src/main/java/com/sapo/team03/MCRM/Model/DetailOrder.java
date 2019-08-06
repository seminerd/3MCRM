package com.sapo.team03.MCRM.Model;

import javax.persistence.*;

@Entity
@Table(name = "ctdonhang")
@IdClass(OrderDetailId.class)
public class CTDonHang {
	@Id
	@Column(name = "id_donhang")
	private Long idDonhang;
	@ManyToOne
	@JoinColumn(name = "id_donhang",insertable = false,updatable = false)
	private DonHang ctDonHang;
	
	@Id
	@Column(name = "id_hanghoa")
	private Long idHanghoa;
	@ManyToOne
	@JoinColumn(name = "id_hanghoa",insertable = false,updatable = false)
	private HangHoa ctHangHoa;
	
	@Column(name = "chiet_khau")
	private Integer chietKhau;
	@Column(name = "so_luong")
	private int soLuong;
	@Column(name = "don_gia")
	private Double donGia;
	@Column(name = "thanh_tien")
	private Double thanhTien;

	public DonHang getCtDonHang() {
		return ctDonHang;
	}
	public void setCtDonHang(DonHang ctDonHang) {
		this.ctDonHang = ctDonHang;
	}

	public HangHoa getCtHangHoa() {
		return ctHangHoa;
	}
	public void setCtHangHoa(HangHoa ctHangHoa) {
		this.ctHangHoa = ctHangHoa;
	}


	public Long getIdDonhang() {
		return idDonhang;
	}
	public void setIdDonhang(Long idDonhang) {
		this.idDonhang = idDonhang;
	}
	public Long getIdHanghoa() {
		return idHanghoa;
	}
	public void setIdHanghoa(Long idHanghoa) {
		this.idHanghoa = idHanghoa;
	}
	public Integer getChietKhau() {
		return chietKhau;
	}
	public void setChietKhau(Integer chietKhau) {
		this.chietKhau = chietKhau;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public Double getDonGia() {
		return donGia;
	}
	public void setDonGia(Double donGia) {
		this.donGia = donGia;
	}
	public Double getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(Double thanhTien) {
		this.thanhTien = thanhTien;
	}
	public CTDonHang() {
		
	}
}
