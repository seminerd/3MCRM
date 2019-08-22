package com.sapo.team03.MCRM.Sale.Model;

import javax.persistence.*;

@Entity
@Table(name = "detail_order")
@IdClass(OrderDetailId.class)
public class OrderDetail {
	@Id
	@Column(name = "id_order")
	private Long idOrder;
	@ManyToOne
	@JoinColumn(name = "id_order",insertable = false,updatable = false)
	private Orders orderOrder;
	
	@Id
	@Column(name = "id_product")
	private Long idProduct;
	@ManyToOne
	@JoinColumn(name = "id_product",insertable = false,updatable = false)
	private Product productOrder;
	
	@Column(name = "discount")
	private Integer discount;
	@Column(name = "quantity")
	private int quantity;
	@Column(name = "unit_price")
	private Double unitPrice;
	@Column(name = "final_price")
	private Double finalPrice;
	public Orders getOrderOrder() {
		return orderOrder;
	}
	public void setOrderOrder(Orders orderOrder) {
		this.orderOrder = orderOrder;
	}
	public Product getProductOrder() {
		return productOrder;
	}
	public void setProductOrder(Product productOrder) {
		this.productOrder = productOrder;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Double getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(Double finalPrice) {
		this.finalPrice = finalPrice;
	}
	public Long getIdOrder() {
		return idOrder;
	}
	public Long getIdProduct() {
		return idProduct;
	}
	
	public void setIdOrder(Long idOrder) {
		this.idOrder = idOrder;
	}
	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}
	public OrderDetail() {
		
	}
}
