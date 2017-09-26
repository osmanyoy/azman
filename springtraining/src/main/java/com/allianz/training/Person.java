package com.allianz.training;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


@NamedQueries(value={
	@NamedQuery(query="select p from Person p where p.name= :name", name = "Person.test")	
})
@Component
@Entity
public class Person implements InitializingBean, BeanNameAware, ApplicationContextAware,DisposableBean{

	@Id
	@GeneratedValue
	private long personId;
	
	private String name;
	private String surname;
	
	@NotNull
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="personcredentialid",nullable=false)
	private PersonCredential personCredential;

	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL,mappedBy="person")
	private List<PersonAccount> personAccounts;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Init bean callback");
	}

	@Override
	public void setBeanName(String bName) {
		System.out.println("My bean name : " + bName);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

	}

	@Override
	public void destroy() throws Exception {
		
	}

	public long getPersonId() {
		return personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}

	public PersonCredential getPersonCredential() {
		return personCredential;
	}

	public void setPersonCredential(PersonCredential personCredential) {
		this.personCredential = personCredential;
	}

	public List<PersonAccount> getPersonAccounts() {
		return personAccounts;
	}

	public void setPersonAccounts(List<PersonAccount> personAccounts) {
		this.personAccounts = personAccounts;
	}

}
