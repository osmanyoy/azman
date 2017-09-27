package com.allianz.training.rest;

import java.util.ArrayList;
import java.util.List;

import org.allianz.test.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.allianz.training.EAccountType;
import com.allianz.training.Person;
import com.allianz.training.PersonAccount;
import com.allianz.training.PersonCredential;
import com.allianz.training.db.PersonDAO;

@RestController
public class MyRestfulWS {

	@Autowired
	private PersonDAO personDAO;
	
	@PreAuthorize("hasRole('USER')")
	@RequestMapping(path = "/hello", method = RequestMethod.GET)
	public String helloWorld() {
		return "hello";
	}

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(path = "/hello2", method = RequestMethod.GET)
    public String helloWorld2() {
        return "hello";
    }

	@RequestMapping(path = "/test1/{isim}", method = RequestMethod.GET)
	public String test1(@PathVariable("isim") String name, @RequestParam("soyisim") String surname,
			@RequestHeader("age") int age) {
		return "hello " + name + " " + surname + " age : " + age;
	}

	@RequestMapping(path = "/test2/{isim}", method = RequestMethod.GET, produces = { "application/xml",
			"application/json" })
	public Employee test2(@PathVariable("isim") String name, @RequestParam("soyisim") String surname,
			@RequestHeader("age") int age) {
		Employee employee = new Employee();
		employee.setAge(age);
		employee.setName(name);
		employee.setSurname(surname);

		return employee;
	}

	@RequestMapping(path = "/test2", method = RequestMethod.POST, produces = { "application/xml",
			"application/json" }, consumes = { "application/xml", "application/json" })
	public Employee test3(@Validated @RequestBody Employee employeeIn) {
		Employee employee = new Employee();
		employee.setAge(employeeIn.getAge());
		employee.setName(employeeIn.getName());
		employee.setSurname(employeeIn.getSurname());

		return employee;
	}

	@RequestMapping(path = "/test4", method = RequestMethod.POST, produces = { "application/xml",
			"application/json" }, consumes = { "application/xml", "application/json" })
	public ResponseEntity<?> test4(@RequestBody Employee employeeIn) {
		if (employeeIn.getName() == null || employeeIn.getSurname() == null) {
			return ResponseEntity.badRequest().body(ErrorObject.createValidationError("Name yada surname girilmedi"));

		}
		Employee employee = new Employee();
		employee.setAge(employeeIn.getAge());
		employee.setName(employeeIn.getName());
		employee.setSurname(employeeIn.getSurname());

		return ResponseEntity.ok(employee);
	}

	@RequestMapping(path = "/person/{name}/{surname}/{username}/{pass}", method = RequestMethod.GET)
	public String personCreate(@PathVariable("name") String name, 
			@PathVariable("surname") String surname,
			@PathVariable("username") String username,
			@PathVariable("pass") String pass
			) {
		Person person = new Person();
		person.setName(name);
		person.setSurname(surname);
		
		PersonCredential credential = new PersonCredential();
		credential.setUsername(username);
		credential.setPassword(pass);
		
		person.setPersonCredential(credential);
		
		List<PersonAccount> personAccounts = new ArrayList<>();

		PersonAccount personAccount = new PersonAccount();
		personAccount.setDescription("dolar");
		personAccount.setAccType(EAccountType.USD);
		personAccount.setPerson(person);
		
		personAccounts.add(personAccount);
		
		personAccount = new PersonAccount();
		personAccount.setDescription("tl hesabı");
		personAccount.setAccType(EAccountType.TL);
		personAccount.setPerson(person);
		
		personAccounts.add(personAccount);
		
		person.setPersonAccounts(personAccounts);
		
		personDAO.save(person);
		return "OK";
	}

}
