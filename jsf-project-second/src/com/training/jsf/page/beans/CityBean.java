package com.training.jsf.page.beans;

import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.training.jsf.dao.CityDAO;
import com.training.jsf.model.City;

@Named
@RequestScoped
public class CityBean {
	private City city = new City();

	private Date myDate;

	@Inject
	private CityDAO cityDAO;

	private String buttonName = "Create";

	private void clear() {
		this.city = new City();
	}

	public String create() {

		if (this.city.getCityId() == null) {
			this.cityDAO.saveCity(this.city);
		} else {
			this.cityDAO.updateCity(this.city);
		}
		this.clear();
		return "city";
	}

	public String deleteCity(final City city) {
		this.cityDAO.deleteCity(city);
		return "city";
	}

	public String editCity(final City city) {
		this.city = city;
		this.buttonName = "Update";
		return "city";
	}

	public List<City> getCities() {
		return this.cityDAO.getAllCities();
	}

	public City getCity() {
		return this.city;
	}

	public void setCity(final City city) {
		this.city = city;
	}

	public String getButtonName() {
		return this.buttonName;
	}

	public void setButtonName(final String buttonName) {
		this.buttonName = buttonName;
	}

	public Date getMyDate() {
		return this.myDate;
	}

	public void setMyDate(final Date myDate) {
		this.myDate = myDate;
	}

}
