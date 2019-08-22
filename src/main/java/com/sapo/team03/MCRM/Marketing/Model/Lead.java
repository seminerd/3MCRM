package com.sapo.team03.MCRM.Marketing.Model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.poi.ss.usermodel.Row;

import com.sapo.team03.MCRM.Sale.Model.CategoryProduct;

@Entity
@Table(name = "lead")
public class Lead {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	@Column(name = "name")
	private String name;
	@Column(name = "email")
	private String email;
	public Lead() {
		super();
		 interest = new HashSet<CategoryProduct>();
	
	}
	@Column(name = "phone")
	private String phone;
	@ManyToMany
	@JoinTable(name = "lead_category", 
	joinColumns = @JoinColumn(name = "id_lead"), 
	inverseJoinColumns = @JoinColumn(name = "id_category"))
	private Set<CategoryProduct> interest ;
	@Column(name = "opportunity")
	private Integer opportunity;
	@Column(name = "create_date")
	private Date create_date;
	@ManyToOne
	@JoinColumn(name = "source")
	private LeadSource source;
	public String getName() {
		return name;
	}
	public void assignLead(Row row){
	   this.name = row.getCell(0).toString();
	    this.email= row.getCell(1).toString();
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Set<CategoryProduct> getInterest() {
		return interest;
	}
	public void setInterest(CategoryProduct interest) {
		this.interest.add(interest);
	}
	public Integer getOpportunity() {
		return opportunity;
	}
	public void setOpportunity(Integer opportunity) {
		this.opportunity = opportunity;
	}
	public long getId() {
		return id;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public LeadSource getSource() {
		return source;
	}
	public void setSource(LeadSource source) {
		this.source = source;
	}

}
