package com.training.jsf.page.beans;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.training.jsf.dao.CityDAO;
import com.training.jsf.dao.TownDAO;
import com.training.jsf.model.City;
import com.training.jsf.model.Town;

@Named
@SessionScoped
public class TownBean implements Serializable {
	private static final long serialVersionUID = 1619290000449025040L;

	private City city;
	private Long selectedCity;
	private Town town = new Town();

	@Inject
	private CityDAO cityDAO;

	@Inject
	private TownDAO townDAO;

	private String buttonName = "Create";

	private void clear() {
		buttonName = "Create";
		town = new Town();
	}
	public String delete(final Town town) {
		this.townDAO.deleteTown(town);
		return "town";
	}

	public String edit(final Town town) {
		this.buttonName = "Update";
		this.town = town;
		return "town";
	}

	public List<Town> getTowns() {
		return this.townDAO.getAllTown(this.selectedCity);
	}

	public void create() {
		this.town.setCity(this.city);
		if (town.getTownId() > 0) {
			this.townDAO.updateTown(this.town);
		} else {
			this.townDAO.saveTown(this.town);
		}
		this.town = new Town();
		clear();
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

	public Town getTown() {
		return this.town;
	}

	public void setTown(final Town town) {
		this.town = town;
	}

	public String getButtonName() {
		return this.buttonName;
	}

	public void setButtonName(final String buttonName) {
		this.buttonName = buttonName;
	}

	public Long getSelectedCity() {
		return this.selectedCity;
	}

	public void setSelectedCity(final Long selectedCity) {
		if (selectedCity != null) {
			this.city = this.townDAO.getCity(selectedCity);
		} else {
			this.city = null;
		}
		
		this.selectedCity = selectedCity;
	}

}
