package com.sapo.team03.MCRM.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "ctdonhang")
public class CTDonHang implements Serializable{
	@Id
	private Long idDonhang;
	@ManyToOne
	@JoinColumn(name = "id_donhang")
	@MapsId
	private DonHang ctDonHang;
	
	@Id
	private Long idHanghoa;
	@ManyToOne
	@JoinColumn(name = "id_hanghoa")
	@MapsId
	private HangHoa ctHangHoa;
	
	@Column(name = "chiet_khau")
	private int chietKhau;
	@Column(name = "so_luong")
	private int soLuong;
	@Column(name = "don_gia")
	private Double donGia;
	@Column(name = "thanh_tien")
	private Double thanhTien;
	public Long getIdDonhang() {
		return idDonhang;
	}
	public void setIdDonhang(Long idDonhang) {
		this.idDonhang = idDonhang;
	}
	public DonHang getCtDonHang() {
		return ctDonHang;
	}
	public void setCtDonHang(DonHang ctDonHang) {
		this.ctDonHang = ctDonHang;
	}
	public Long getIdHanghoa() {
		return idHanghoa;
	}
	public void setIdHanghoa(Long idHanghoa) {
		this.idHanghoa = idHanghoa;
	}
	public HangHoa getCtHangHoa() {
		return ctHangHoa;
	}
	public void setCtHangHoa(HangHoa ctHangHoa) {
		this.ctHangHoa = ctHangHoa;
	}
	public int getChietKhau() {
		return chietKhau;
	}
	public void setChietKhau(int chietKhau) {
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
