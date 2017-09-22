package com.allianz.training.ee.rest;

import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.validator.constraints.NotBlank;

@NamedQueries({ @NamedQuery(name = "employeeSelectAll", query = "select e from Employee e"),
		@NamedQuery(name = "employeeSelectAllByNameParameter", query = "select e from Employee e where e.name = :nm"),
		@NamedQuery(name = "employeeSelectAllByNameIndex", query = "select e from Employee e where e.name = ?1")

})
@NamedNativeQueries({ @NamedNativeQuery(name = "selectFromEmployee", query = "select * from calisan where name= :nm") })
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
// @XmlType(name = "Calisan", namespace = "http://common.allainz.com", propOrder
// = { "isim", "soyisim", "age", "gender",
// "address", "birthdate", "employeeExtra", "test", "username", "password",
// "accounts" })
@Entity
@Table(name = "calisan")
@SecondaryTable(name = "calisan_info")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlTransient
	private long id;

	@XmlElement(name = "isim", nillable = false, required = true)
	private String name;

	@Size(min = 3, max = 50, message = "soyisim yanl��")
	// @Pattern(regexp="\\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}\\b")
	@Column(name = "soyisim", nullable = false, length = 50)
	private String surname;

	@Min(value=3)
	@Max(value=120)
	private int age;
	@Enumerated(EnumType.STRING)
	@NotNull
	private EGender gender;

	@Temporal(TemporalType.DATE)
	@Past(message="Please enter old date !")
	private Date birthdate;

	@Embedded
	@AttributeOverride(column = @Column(name = "testStreet"), name = "street")
	private Address address;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "join_employee_extra", nullable = false, unique = true)
	private EmployeeExtra employeeExtra;

	@XmlTransient
	@Basic(fetch = FetchType.LAZY)
	private String test = "test";

	@Column(table = "calisan_info", unique = true)
	private String username;
	@Column(table = "calisan_info")
	private String password;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "employee")
	private List<EmployeeAccount> accounts;

	@PrePersist
	@PreUpdate
	public void method1() {
		password = new String(Base64.getEncoder().encode(password.getBytes()));
	}

	@PostUpdate
	@PostPersist
	@PostLoad
	public void method2() {
		password = new String(Base64.getDecoder().decode(password.getBytes()));
	}

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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public EGender getGender() {
		return gender;
	}

	public void setGender(EGender gender) {
		this.gender = gender;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public EmployeeExtra getEmployeeExtra() {
		return employeeExtra;
	}

	public void setEmployeeExtra(EmployeeExtra employeeExtra) {
		this.employeeExtra = employeeExtra;
	}

	public List<EmployeeAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<EmployeeAccount> accounts) {
		this.accounts = accounts;
	}

}
