package com.sapo.team03.MCRM.Service.StatisticModel;

public class Statistics {
	private int totalCustomers;
	private int totalStaffs;
	private int totalOrders;
	private Double revenue;
	private int totalLead;
	private int totalOpp;
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
	
	public int getTotalLead() {
		return totalLead;
	}
	public void setTotalLead(int totalLead) {
		this.totalLead = totalLead;
	}

	public int getTotalOpp() {
		return totalOpp;
	}
	public void setTotalOpp(int totalOpp) {
		this.totalOpp = totalOpp;
	}
	public Statistics() {
	}
}
