package com.allianz.training.ee.rest;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlTransient;

@Entity
public class EmployeeAccount {
	
	@Id
	@GeneratedValue
	private long accId;
	private double amount;
	private String accountName;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@XmlTransient
	private Employee employee;
	
	
	public EmployeeAccount() {
	}
	
	public EmployeeAccount(double amount, String accountName) {
		super();
		this.amount = amount;
		this.accountName = accountName;
	}
	
	public long getAccId() {
		return accId;
	}
	public void setAccId(long accId) {
		this.accId = accId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	
}
