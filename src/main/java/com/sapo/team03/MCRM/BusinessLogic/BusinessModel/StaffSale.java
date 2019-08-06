package com.sapo.team03.MCRM.BusinessLogic.BusinessModel;

public class StaffSale {
	private Long id;
	private Double values;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getValues() {
		return values;
	}
	public void setValues(Double values) {
		this.values = values;
	}
	public StaffSale(Long id, Double values) {
		super();
		this.id = id;
		this.values = values;
	}
	public StaffSale() {
		super();
	}
	
	
	
}