package com.sapo.team03.MCRM.BusinessLogic.BusinessModel;

import java.time.YearMonth;

public class MonthSale {
	private YearMonth month;
	private Double values;
	public MonthSale() {
		super();
	}
	public MonthSale(YearMonth month, Double values) {
		super();
		this.month = month;
		this.values = values;
	}
	public YearMonth getMonth() {
		return month;
	}
	public void setMonth(YearMonth month) {
		this.month = month;
	}
	public Double getValues() {
		return values;
	}
	public void setValues(Double values) {
		this.values = values;
	}
	
}
