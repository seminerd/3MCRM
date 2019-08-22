package com.sapo.team03.MCRM.Service.StatisticModel;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "conversion_rate")
public class Conversion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column(name = "month_year")
	private LocalDate date;
	@Column(name = "lead_opp")
	private int leadToOpportunity;
	@Column(name = "opp_cus")
	private int opportunityToCustomer;
	@Column(name = "lead_cus")
	private int leadToCustomer;
	@Column(name = "total_lead")
	private int totalLead;
	@Column(name = "total_opp")
	private int totalOpportunity;
	@Column(name = "new_customer")
	private int newCustomer;
	
	public Conversion() {
		this.leadToCustomer = 0;
		this.leadToOpportunity = 0;
		this.opportunityToCustomer = 0;
		this.newCustomer = 0;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getLeadToOpportunity() {
		return leadToOpportunity;
	}

	public void setLeadToOpportunity(int leadToOpportunity) {
		this.leadToOpportunity = leadToOpportunity;
	}

	public int getOpportunityToCustomer() {
		return opportunityToCustomer;
	}

	public void setOpportunityToCustomer(int opportunityToCustomer) {
		this.opportunityToCustomer = opportunityToCustomer;
	}

	public int getLeadToCustomer() {
		return leadToCustomer;
	}

	public void setLeadToCustomer(int leadToCustomer) {
		this.leadToCustomer = leadToCustomer;
	}

	public int getTotalLead() {
		return totalLead;
	}

	public void setTotalLead(int totalLead) {
		this.totalLead = totalLead;
	}

	public int getTotalOpportunity() {
		return totalOpportunity;
	}

	public void setTotalOpportunity(int totalOpportunity) {
		this.totalOpportunity = totalOpportunity;
	}

	public int getNewCustomer() {
		return newCustomer;
	}

	public void setNewCustomer(int newCustomer) {
		this.newCustomer = newCustomer;
	}
	
}
