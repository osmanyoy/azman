package com.allianz.training.ee.rest;

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

@Path("/myrest")
public class MyRest {

	@GET
	public String helloWorld() {
		return "Hello Osman";
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
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
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
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Employee method3(Employee empIn) {
		Employee employee = new Employee();
		employee.setName(empIn.getName());
		employee.setSurname(empIn.getSurname());
		employee.setAge(empIn.getAge());
		employee.setGender(empIn.getGender());
		return employee;
	}
	

	@POST
	@Path("/m4/{name}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Person method4(Person empIn) {
		Person person = new Person();
		person.setName(empIn.getName());
		person.setSurname(empIn.getSurname());
		person.setAge(empIn.getAge());
		person.setGender(empIn.getGender());
		return person;
	}


}
