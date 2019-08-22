package com.sapo.team03.MCRM.Marketing.Model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "lead_source")
public class LeadSource {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	@Column(name = "name")
	private String name;
	@Column(name = "create_date")
	private LocalDate date;
	@Column(name = "total")
	private int total;
	@Column(name = "cnvrt")
	private int convert;
	@Column(name = "rate")
	private double rate;
	
	@OneToMany(mappedBy = "source")
	@JsonBackReference("lead")
	private List<Lead> leads;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getConvert() {
		return convert;
	}
	public void setConvert(int convert) {
		this.convert = convert;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public LeadSource() {
		this.convert = 0;
	}
	public List<Lead> getLeads() {
		return leads;
	}
	public void setLeads(List<Lead> leads) {
		this.leads = leads;
	}
	
}
