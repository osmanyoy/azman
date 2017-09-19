package com.allianz.training.ee.rest;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="calisan_extra")
public class EmployeeExtra {
	
	@Id
	@GeneratedValue
	private long empId;
	
	private String spousName;
	private String description;
	
	@XmlTransient
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private Employee employee;
	
	public String getSpousName() {
		return spousName;
	}
	public void setSpousName(String spousName) {
		this.spousName = spousName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
}
