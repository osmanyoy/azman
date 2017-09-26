package com.allianz.training;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PersonAccount {
	
	@Id
	@GeneratedValue
	private long paId;
	
	private String description;
	private EAccountType accType;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private Person person;
	
	public EAccountType getAccType() {
		return accType;
	}
	public void setAccType(EAccountType accType) {
		this.accType = accType;
	}
	public long getPaId() {
		return paId;
	}
	public void setPaId(long paId) {
		this.paId = paId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	
}
