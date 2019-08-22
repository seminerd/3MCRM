package com.sapo.team03.MCRM.Marketing.Model;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "strategy")
public class Marketing {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	@Column(name = "name")
	private String name;
	@Column(name = "date_start")
	private LocalDate startDate;
	@Column(name = "date_finish")
	private LocalDate finishDate;
	@Column(name = "state")
	private Integer state;
	@Column(name = "result")
	private Integer result;
	
	@ManyToMany
	@JoinTable(name = "ob_strategy", 
	joinColumns = @JoinColumn(name = "id_strategy"),
	inverseJoinColumns = @JoinColumn(name = "id_cus_group"))
	private List<CustomerGroup> groupMarketing;
	
	public Marketing() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(LocalDate finishDate) {
		this.finishDate = finishDate;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public List<CustomerGroup> getGroupMarketing() {
		return groupMarketing;
	}

	public void setGroupMarketing(List<CustomerGroup> groupMarketing) {
		this.groupMarketing = groupMarketing;
	}

	public long getId() {
		return id;
	}
	
	
}
