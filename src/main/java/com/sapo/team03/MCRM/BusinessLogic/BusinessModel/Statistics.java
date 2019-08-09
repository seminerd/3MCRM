package com.sapo.team03.MCRM.BusinessLogic.BusinessModel;

public class Statistics {
	private int totalCustomers;
	private int totalStaffs;
	private int totalOrders;
	private Double revenue;
	public int getTotalCustomers() {
		return totalCustomers;
	}
	public void setTotalCustomers(int totalCustomers) {
		this.totalCustomers = totalCustomers;
	}
	public int getTotalStaffs() {
		return totalStaffs;
	}
	public void setTotalStaffs(int totalStaffs) {
		this.totalStaffs = totalStaffs;
	}
	public int getTotalOrders() {
		return totalOrders;
	}
	public void setTotalOrders(int totalOrders) {
		this.totalOrders = totalOrders;
	}
	public Double getRevenue() {
		return revenue;
	}
	public void setRevenue(Double revenue) {
		this.revenue = revenue;
	}
	public Statistics() {
	}
}
