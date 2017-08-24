package com.training.jsf.page.beans;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.facelets.FaceletContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.training.jsf.dao.CityDAO;
import com.training.jsf.dao.CustomerDAO;
import com.training.jsf.model.City;
import com.training.jsf.model.Customer;

@Named
@RequestScoped
public class CreateCustomerBean {
	private Long id;
	// @Size(min=2,max=12,message="Ýsim en az 2 ile 12 arasýnda olmasý lazým")
	private String name;
	
	@Length(max= 12,min=2,message="2 ile 12 arasýnda olsun")
	private String surname;
	
	@Max(value = 120, message = "Yaþ 12 ile 120 arasýnda olmalý")
	@Min(value = 12, message = "Yaþ 12 ile 120 arasýnda olmalý")
	private int age;
	
	@Past(message="Lütfen eski bir zaman yazýnýz")
	@NotNull(message="{com.customer.birthdate} {deneme.prop} hdjhdjh ")
	private Date birthDate;
	private String city;

	private String ageValidationMessage = "Yaþ 12 ile 120 arasýnda olmalý";

	private String buttonName = "Create";

	@Inject
	private CustomerDAO customerDAO;

	@Inject
	private CityDAO cityDAO;
	
	
	@PostConstruct
	public void init() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		String messageBundleName = facesContext.getApplication().getMessageBundle();
		
		System.getProperties().put("deneme.prop", "1000");
	}
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

	public String getAgeValidationMessage() {
		return ageValidationMessage;
	}

	public void setAgeValidationMessage(String ageValidationMessage) {
		this.ageValidationMessage = ageValidationMessage;
	}

}
