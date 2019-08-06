package com.sapo.team03.MCRM.BusinessLogic.BusinessModel;

import java.time.LocalDate;

public class DaySale {
	private LocalDate date;
	private Double values;

	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Double getValues() {
		return values;
	}
	public void setValues(Double values) {
		this.values = values;
	}

	public DaySale(LocalDate date, Double values) {
		super();
		this.date = date;
		this.values = values;
	}
	public DaySale() {
		
	}
}
