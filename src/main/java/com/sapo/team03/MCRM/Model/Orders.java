package com.sapo.team03.MCRM.Model;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "orders")
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column(name = "date_order")
	private Date dateOrder;
	@Column(name = "address_ship")
	private String addressShip;
	@Column(name = "total_money")
	private Double totalMoney;
	@ManyToOne
	@JoinColumn(name = "id_staff_order")
	private Staff staffOrder;
	@ManyToOne
	@JoinColumn(name = "id_customer_order")
	private Customer customerOrder;
	@JsonBackReference("s")
	@OneToMany(mappedBy = "orderOrder",fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
	@ElementCollection
	private Set<OrderDetail> orderDetails;
	@Column(name = "method_pay")
	private String methodPay;
	@Column(name = "state")
	private Integer state;
	@Column(name = "date_ship")
	private Date dateShip;
	@Column(name = "method_ship")
	private String methodShip;
	@Column(name = "note")
	private String note;
	@Column(name = "discount")
	private Integer discount;
	@Column(name = "cost_ship")
	private Double costShip;
	@Column(name = "update_date")
	private Date updateDate;
	
	public Orders() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDateOrder() {
		return dateOrder;
	}
	public void setDateOrder(Date date) {
		this.dateOrder = date;
	}
	public String getAddressShip() {
		return addressShip;
	}
	public void setAddressShip(String addressShip) {
		this.addressShip = addressShip;
	}
	
	public Double getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
	}
	public Staff getStaffOrder() {
		return staffOrder;
	}
	public void setStaffOrder(Staff staffOrder) {
		this.staffOrder = staffOrder;
	}
	public Customer getCustomerOrder() {
		return customerOrder;
	}
	public void setCustomerOrder(Customer customerOrder) {
		this.customerOrder = customerOrder;
	}
	public Set<OrderDetail> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	public String getMethodPay() {
		return methodPay;
	}
	public void setMethodPay(String methodPay) {
		this.methodPay = methodPay;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Date getDateShip() {
		return dateShip;
	}
	public void setDateShip(Date dateShip) {
		this.dateShip = dateShip;
	}
	public String getMethodShip() {
		return methodShip;
	}
	public void setMethodShip(String methodShip) {
		this.methodShip = methodShip;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	public Double getCostShip() {
		return costShip;
	}
	public void setCostShip(Double costShip) {
		this.costShip = costShip;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	
}
