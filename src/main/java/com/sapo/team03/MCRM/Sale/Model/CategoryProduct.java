package com.sapo.team03.MCRM.Sale.Model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sapo.team03.MCRM.Marketing.Model.Lead;

@Entity
@Table(name = "category_product")
public class CategoryProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "quantity")
	private Integer quantity;
	@JsonBackReference("z")
	@OneToMany(mappedBy = "categoryProduct")
	private Set<Product> products;
	@ManyToMany(mappedBy="interest")
	private Set<Lead> interestedLead;
	
	public CategoryProduct() {
		
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public CategoryProduct(String name) {
		super();
		this.name = name;
	}
	
}
