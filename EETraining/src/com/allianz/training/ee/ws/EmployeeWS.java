package com.allianz.training.ee.ws;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.xml.ws.RequestWrapper;

import com.allianz.training.ee.ejb.TrainingDAO;
import com.allianz.training.ee.rest.Address;
import com.allianz.training.ee.rest.Employee;
import com.allianz.training.ee.rest.EmployeeAccount;
import com.allianz.training.ee.rest.EmployeeExtra;

@WebService(targetNamespace="http://ws.allianz.com")
@Path("/emp")
public class EmployeeWS {
	
	@EJB
	private TrainingDAO trainingDAO;
	
	@WebMethod(exclude = true)
	public String test(String str) {
		return "test";
	}
	
	@WebMethod(operationName="merhabaDunya")
	@RequestWrapper(partName="testHello")
	@GET
	public String helloWorld(@WebParam(name = "str") @QueryParam("str") String str) {
		return "Hello " + str; 
	}
	
	public EmployeeList allEmployees(){
		EmployeeList employeeList = new EmployeeList();
		
		List<Employee> allEmployees = trainingDAO.getAllEmployees();
		employeeList.setEmployees(allEmployees);
		return employeeList;
	}
	
	public Employee createEmployee(Employee empIn) {


		// EntityTransaction transaction = manager.getTransaction();
		// transaction.begin();
		// try {
		// manager.persist(empIn);
		// transaction.commit();
		// } catch (Exception e) {
		// transaction.rollback();
		// e.printStackTrace();
		// }
		Address address = new Address();
		address.setStreet("atasehir");
		address.setPostcode(34455);
		
		EmployeeExtra employeeExtra = new EmployeeExtra();
		employeeExtra.setSpousName("Nil");
		employeeExtra.setDescription("Test desc");
		
		empIn.setEmployeeExtra(employeeExtra);
		
		empIn.setAddress(address);
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.set(Calendar.YEAR, 1970);
		calendar.set(Calendar.MONTH, 9);
		calendar.set(Calendar.DATE,11);
		Date birthdate = new Date(calendar.getTimeInMillis());
		empIn.setBirthdate(birthdate);

		List<EmployeeAccount> accounts =  new ArrayList<>();
		EmployeeAccount employeeAccount = new EmployeeAccount(0D, "TestAcc1");
		employeeAccount.setEmployee(empIn);
		accounts.add(employeeAccount);
		EmployeeAccount employeeAccount2 = new EmployeeAccount(0D, "TestAcc2");
		employeeAccount2.setEmployee(empIn);
		accounts.add(employeeAccount2);
		empIn.setAccounts(accounts);
		
		empIn.setUsername("osman");
		empIn.setPassword("123");
		
		try {
			trainingDAO.writeEmployee(empIn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Employee employee = new Employee();
		employee.setName(empIn.getName());
		employee.setSurname(empIn.getSurname());
		employee.setAge(empIn.getAge());
		employee.setGender(empIn.getGender());
		employee.setBirthdate(birthdate);
		employee.setAddress(address);
		
		return employee;
	}
}
