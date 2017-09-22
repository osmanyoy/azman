package com.allianz.training.ee.rest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.Size;
import javax.validation.executable.ValidateOnExecution;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.allianz.training.ee.ejb.TrainingDAO;

@Path("/myrest")
public class MyRest {
	
	@EJB
	private TrainingDAO trainingDAO;
	
	@GET
	public String helloWorld(@Size(min=5,message="name en az 5 olmalý") @QueryParam("name") String name) {
		return "Hello " + name;
	}

	@POST
	@Path("/m1/{name}/{surname}")
	public String method1(@PathParam("name") String isim, @PathParam("surname") String soyisim,
			@QueryParam("age") int age, @QueryParam("gender") EGender gender, @HeaderParam("job") String meslek,
			@FormParam("dep") String dep, @MatrixParam("phone") String phone) {
		return "Hello " + isim + " " + soyisim + " age=" + age + " gender=" + gender + " job=" + meslek + " dep=" + dep
				+ " phone" + phone;
	}

	@GET
	@Path("/m2")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Employee method2() {
		Employee employee = new Employee();
		employee.setName("osman");
		employee.setSurname("yaycioglu");
		employee.setAge(47);
		employee.setGender(EGender.MALE);
		return employee;
	}

	@POST
	@Path("/m3")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Employee method3(Employee empIn) {


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

	@POST
	@Path("/m4/{name}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Person method4(@BeanParam Person empIn) {
		Person person = new Person();
		person.setName(empIn.getName());
		person.setSurname(empIn.getSurname());
		person.setAge(empIn.getAge());
		person.setGender(empIn.getGender());
		return person;
	}

}
