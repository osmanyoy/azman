package com.training.jsf.page.beans;

import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

import com.training.jsf.dao.CityDAO;
import com.training.jsf.dao.CustomerDAO;
import com.training.jsf.model.City;
import com.training.jsf.model.Customer;

@Named
@RequestScoped
public class CreateCustomerBean {
	private Long id;
	private String name;
	private String surname;
	private int age;
	private Date birthDate;
	private String city;

	private String buttonName = "Create";

	@Inject
	private CustomerDAO customerDAO;

	@Inject
	private CityDAO cityDAO;

	public List<City> getCities() {
		return this.cityDAO.getAllCities();
	}

	public List<Customer> getCustomerList() {
		return this.customerDAO.getAllCustomers();
	}

	public void ajaxMethod(final AjaxBehaviorEvent behaviorEvent) {
		System.out.println("burasi");
	}

	private void clear() {
		this.name = null;
		this.surname = null;
		this.id = null;
	}

	public String create() {
		Customer customer = new Customer();
		customer.setName(this.name);
		customer.setSurname(this.surname);
		customer.setBirthDate(this.birthDate);
		customer.setCity(this.city);
		customer.setAge(this.age);

		if (this.id == null) {
			this.customerDAO.saveCustomer(customer);
		} else {
			customer.setCustomerId(this.id);
			this.customerDAO.updateCustomer(customer);
		}
		this.clear();
		return "createUser";
	}

	public String delete(final Customer customer) {
		this.customerDAO.deleteCustomer(customer);
		this.clear();
		return "createUser";
	}

	public String edit(final Customer customer) {
		this.name = customer.getName();
		this.surname = customer.getSurname();
		this.id = customer.getCustomerId();
		this.buttonName = "Update";
		return "createUser";
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(final String surname) {
		this.surname = surname;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getButtonName() {
		return this.buttonName;
	}

	public void setButtonName(final String buttonName) {
		this.buttonName = buttonName;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(final int age) {
		this.age = age;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(final Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(final String city) {
		this.city = city;
	}

}
