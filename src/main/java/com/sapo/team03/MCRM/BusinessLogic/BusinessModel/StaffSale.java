package com.sapo.team03.MCRM.BusinessLogic.BusinessModel;

public class StaffSale {
	private Long id;
	private String name;
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
	public StaffSale(Long id, Double values, String name) {
		super();
		this.id = id;
		this.values = values;
		this.name = name;
	}
	public StaffSale() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}