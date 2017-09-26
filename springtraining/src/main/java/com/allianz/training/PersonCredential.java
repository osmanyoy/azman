package com.allianz.training;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="xyz")
public class PersonCredential {
	
	@Id
	@GeneratedValue
	private long pcId;
	
	@NotNull
	@Size(min=3,max=20)
	@Column(name="help",unique=true,nullable=false,length=20)
	private String username;
	@Column(name="melp",unique=false,nullable=false,length=20)
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getPcId() {
		return pcId;
	}
	public void setPcId(long pcId) {
		this.pcId = pcId;
	}
	
	
}
