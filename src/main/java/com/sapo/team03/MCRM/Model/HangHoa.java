	package com.sapo.team03.MCRM.Model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "hanghoa")
public class HangHoa {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column(name = "ten")
	private String ten;
	@Column(name = "xuat_su")
	private String xuat_su;
	@Column(name = "hang_sx")
	private String hang_sx;
	@Column(name = "so_luong")
	private Integer so_luong;
	@Column(name = "gia_nhap")
	private Double gia_nhap;
	@Column(name = "gia_xuatbuon")
	private Double gia_xuatbuon;
	@Column(name = "thue")
	private Integer thue;
	@Column(name = "mo_ta")
	private String mo_ta;
	@Column(name = "hinh_anh")
	private String hinh_anh;
	
	@ManyToOne
	@JoinColumn(name = "id_categoryhh")
	private CategoryHangHoa categoryHangHoa;
	
	@Column(name = "soluong_daban")
	private Integer soluong_daban;
	@Column(name = "gia_xuatle")
	private Double gia_xuatle;
	@Column(name = "don_vi")
	private String don_vi;
	@JsonBackReference("w")
	@OneToMany(mappedBy = "ctHangHoa")
	private Set<CTDonHang> ctDonHang;
	@Column(name="ten_cat")
	private String catName;
	
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
	public String getXuat_su() {
		return xuat_su;
	}
	public void setXuat_su(String xuat_su) {
		this.xuat_su = xuat_su;
	}
	public String getHang_sx() {
		return hang_sx;
	}
	public void setHang_sx(String hang_sx) {
		this.hang_sx = hang_sx;
	}

	public Integer getSo_luong() {
		return so_luong;
	}
	public void setSo_luong(Integer so_luong) {
		this.so_luong = so_luong;
	}
	public Double getGia_nhap() {
		return gia_nhap;
	}
	public void setGia_nhap(Double gia_nhap) {
		this.gia_nhap = gia_nhap;
	}
	public Double getGia_xuatbuon() {
		return gia_xuatbuon;
	}
	public void setGia_xuatbuon(Double gia_xuatbuon) {
		this.gia_xuatbuon = gia_xuatbuon;
	}

	public Integer getThue() {
		return thue;
	}
	public void setThue(Integer thue) {
		this.thue = thue;
	}
	public String getMo_ta() {
		return mo_ta;
	}
	public void setMo_ta(String mo_ta) {
		this.mo_ta = mo_ta;
	}
	public String getHinh_anh() {
		return hinh_anh;
	}
	public void setHinh_anh(String hinh_anh) {
		this.hinh_anh = hinh_anh;
	}
	public Integer getSoluong_daban() {
		return soluong_daban;
	}
	public void setSoluong_daban(Integer soluong_daban) {
		this.soluong_daban = soluong_daban;
	}

	public Double getGia_xuatle() {
		return gia_xuatle;
	}
	public void setGia_xuatle(Double gia_xuatle) {
		this.gia_xuatle = gia_xuatle;
	}
	public CategoryHangHoa getCategoryHangHoa() {
		return categoryHangHoa;
	}
	public void setCategoryHangHoa(CategoryHangHoa categoryHangHoa) {
		this.categoryHangHoa = categoryHangHoa;
	}
	public Set<CTDonHang> getCtDonHang() {
		return ctDonHang;
	}
	public void setCtDonHang(Set<CTDonHang> ctDonHang) {
		this.ctDonHang = ctDonHang;
	}
	
	public String getDon_vi() {
		return don_vi;
	}
	public void setDon_vi(String don_vi) {
		this.don_vi = don_vi;
	}
	
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public HangHoa() {
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gia_nhap == null) ? 0 : gia_nhap.hashCode());
		result = prime * result + ((gia_xuatbuon == null) ? 0 : gia_xuatbuon.hashCode());
		result = prime * result + ((gia_xuatle == null) ? 0 : gia_xuatle.hashCode());
		result = prime * result + ((hang_sx == null) ? 0 : hang_sx.hashCode());
		result = prime * result + ((hinh_anh == null) ? 0 : hinh_anh.hashCode());
		result = prime * result + ((ten == null) ? 0 : ten.hashCode());
		result = prime * result + ((thue == null) ? 0 : thue.hashCode());
		result = prime * result + ((xuat_su == null) ? 0 : xuat_su.hashCode());
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
		HangHoa other = (HangHoa) obj;
		if (gia_nhap == null) {
			if (other.gia_nhap != null)
				return false;
		} else if (!gia_nhap.equals(other.gia_nhap))
			return false;
		if (gia_xuatbuon == null) {
			if (other.gia_xuatbuon != null)
				return false;
		} else if (!gia_xuatbuon.equals(other.gia_xuatbuon))
			return false;
		if (gia_xuatle == null) {
			if (other.gia_xuatle != null)
				return false;
		} else if (!gia_xuatle.equals(other.gia_xuatle))
			return false;
		if (hang_sx == null) {
			if (other.hang_sx != null)
				return false;
		} else if (!hang_sx.equals(other.hang_sx))
			return false;
		if (hinh_anh == null) {
			if (other.hinh_anh != null)
				return false;
		} else if (!hinh_anh.equals(other.hinh_anh))
			return false;
		if (ten == null) {
			if (other.ten != null)
				return false;
		} else if (!ten.equals(other.ten))
			return false;
		if (thue == null) {
			if (other.thue != null)
				return false;
		} else if (!thue.equals(other.thue))
			return false;
		if (xuat_su == null) {
			if (other.xuat_su != null)
				return false;
		} else if (!xuat_su.equals(other.xuat_su))
			return false;
		return true;
	}
	
		
}
