package com.sapo.team03.MCRM.Model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "hanghoa")
public class HangHoa {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column(name = "ten")
	private String name;
	@Column(name = "xuat_su")
	private String xuatSu;
	@Column(name = "hang_sx")
	private String hangSx;
	@Column(name = "so_luong")
	private int soLuong;
	@Column(name = "gia_nhap")
	private Double giaNhap;
	@Column(name = "gia_xuat")
	private Double giaXuat;
	@Column(name = "thue")
	private int thue;
	@Column(name = "bao_hanh")
	private String baoHanh;
	@Column(name = "han_sd")
	private LocalDate hanSD;
	@Column(name = "mo_ta")
	private String mota;
	@Column(name = "hinh_anh")
	private String hinhAnh;
	@ManyToOne
	@JoinColumn(name = "id_categoryhh")
	private CategoryHangHoa categoryHangHoa;
	@OneToMany(mappedBy = "ctHangHoa")
	private Set<CTDonHang> ctDonHang;
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
	public String getXuatSu() {
		return xuatSu;
	}
	public void setXuatSu(String xuatSu) {
		this.xuatSu = xuatSu;
	}
	public String getHangSx() {
		return hangSx;
	}
	public void setHangSx(String hangSx) {
		this.hangSx = hangSx;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public Double getGiaNhap() {
		return giaNhap;
	}
	public void setGiaNhap(Double giaNhap) {
		this.giaNhap = giaNhap;
	}
	public Double getGiaXuat() {
		return giaXuat;
	}
	public void setGiaXuat(Double giaXuat) {
		this.giaXuat = giaXuat;
	}
	public int getThue() {
		return thue;
	}
	public void setThue(int thue) {
		this.thue = thue;
	}
	public String getBaoHanh() {
		return baoHanh;
	}
	public void setBaoHanh(String baoHanh) {
		this.baoHanh = baoHanh;
	}
	public LocalDate getHanSD() {
		return hanSD;
	}
	public void setHanSD(LocalDate hanSD) {
		this.hanSD = hanSD;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
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
	
	public HangHoa() {
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((baoHanh == null) ? 0 : baoHanh.hashCode());
		result = prime * result + ((categoryHangHoa == null) ? 0 : categoryHangHoa.hashCode());
		result = prime * result + ((giaNhap == null) ? 0 : giaNhap.hashCode());
		result = prime * result + ((giaXuat == null) ? 0 : giaXuat.hashCode());
		result = prime * result + ((hanSD == null) ? 0 : hanSD.hashCode());
		result = prime * result + ((hangSx == null) ? 0 : hangSx.hashCode());
		result = prime * result + ((hinhAnh == null) ? 0 : hinhAnh.hashCode());
		result = prime * result + ((mota == null) ? 0 : mota.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + soLuong;
		result = prime * result + thue;
		result = prime * result + ((xuatSu == null) ? 0 : xuatSu.hashCode());
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
		if (baoHanh == null) {
			if (other.baoHanh != null)
				return false;
		} else if (!baoHanh.equals(other.baoHanh))
			return false;
		if (categoryHangHoa == null) {
			if (other.categoryHangHoa != null)
				return false;
		} else if (!categoryHangHoa.equals(other.categoryHangHoa))
			return false;
		if (giaNhap == null) {
			if (other.giaNhap != null)
				return false;
		} else if (!giaNhap.equals(other.giaNhap))
			return false;
		if (giaXuat == null) {
			if (other.giaXuat != null)
				return false;
		} else if (!giaXuat.equals(other.giaXuat))
			return false;
		if (hanSD == null) {
			if (other.hanSD != null)
				return false;
		} else if (!hanSD.equals(other.hanSD))
			return false;
		if (hangSx == null) {
			if (other.hangSx != null)
				return false;
		} else if (!hangSx.equals(other.hangSx))
			return false;
		if (hinhAnh == null) {
			if (other.hinhAnh != null)
				return false;
		} else if (!hinhAnh.equals(other.hinhAnh))
			return false;
		if (mota == null) {
			if (other.mota != null)
				return false;
		} else if (!mota.equals(other.mota))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (soLuong != other.soLuong)
			return false;
		if (thue != other.thue)
			return false;
		if (xuatSu == null) {
			if (other.xuatSu != null)
				return false;
		} else if (!xuatSu.equals(other.xuatSu))
			return false;
		return true;
	}
	
}
