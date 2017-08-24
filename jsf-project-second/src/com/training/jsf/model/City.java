package com.training.jsf.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cityId;
	private String cityName;
	private String cityPlate;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "city")
	private List<Town> towns;

	public Long getCityId() {
		return this.cityId;
	}

	public void setCityId(final Long cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(final String cityName) {
		this.cityName = cityName;
	}

	public String getCityPlate() {
		return this.cityPlate;
	}

	public void setCityPlate(final String cityPlate) {
		this.cityPlate = cityPlate;
	}

	public List<Town> getTowns() {
		return this.towns;
	}

	public void setTowns(final List<Town> towns) {
		this.towns = towns;
	}

}
