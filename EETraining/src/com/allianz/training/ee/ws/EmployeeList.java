package com.allianz.training.ee.ws;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.allianz.training.ee.rest.Employee;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeList {
	
	@XmlElement(name = "employee")
	private List<Employee> employees;

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
}
