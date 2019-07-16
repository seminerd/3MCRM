package com.sapo.team03.MCRM.Model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "categoryhanghoa")
public class CategoryHangHoa {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column(name = "ten")
	private String ten;
	@Column(name = "so_luong")
	private int soLuong;
	@OneToMany(mappedBy = "categoryHangHoa")
	private Set<HangHoa> hangHoa;
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
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public Set<HangHoa> getHangHoa() {
		return hangHoa;
	}
	public void setHangHoa(Set<HangHoa> hangHoa) {
		this.hangHoa = hangHoa;
	}
	public CategoryHangHoa() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hangHoa == null) ? 0 : hangHoa.hashCode());
		result = prime * result + ((ten == null) ? 0 : ten.hashCode());
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
		CategoryHangHoa other = (CategoryHangHoa) obj;
		if (hangHoa == null) {
			if (other.hangHoa != null)
				return false;
		} else if (!hangHoa.equals(other.hangHoa))
			return false;
		if (ten == null) {
			if (other.ten != null)
				return false;
		} else if (!ten.equals(other.ten))
			return false;
		return true;
	}
	
	
}
