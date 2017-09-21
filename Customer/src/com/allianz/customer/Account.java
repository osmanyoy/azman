package com.allianz.customer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class Account {
	
	@Id
	@GeneratedValue
	@XmlElement(required=false,nillable = true)
	private long accId;
	private EAccountType accountType;
	private String accountDesc;
	private double amount;
	
	
	public long getAccId() {
		return accId;
	}
	public void setAccId(long accId) {
		this.accId = accId;
	}
	public EAccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(EAccountType accountType) {
		this.accountType = accountType;
	}
	public String getAccountDesc() {
		return accountDesc;
	}
	public void setAccountDesc(String accountDesc) {
		this.accountDesc = accountDesc;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
