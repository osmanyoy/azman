package com.training.jsf.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Town {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long townId;

	private String townName;

	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE }, fetch = FetchType.EAGER)
	private City city;

	public long getTownId() {
		return this.townId;
	}

	public void setTownId(final long townId) {
		this.townId = townId;
	}

	public String getTownName() {
		return this.townName;
	}

	public void setTownName(final String townName) {
		this.townName = townName;
	}

	public City getCity() {
		return this.city;
	}

	public void setCity(final City city) {
		this.city = city;
	}

}
