package com.sapo.team03.MCRM.Model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
	private int so_luong;
	
	@JsonBackReference("z")
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

	public int getSo_luong() {
		return so_luong;
	}
	public void setSo_luong(int so_luong) {
		this.so_luong = so_luong;
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
	
	public CategoryHangHoa(String ten) {
		super();
		this.ten = ten;
	}

	
}
