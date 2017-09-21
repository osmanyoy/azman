package com.allianz.customer;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@WebService(targetNamespace="http://osman.com")
@Path("/")
public class CustomerWS {

	@EJB
	private CustomerDAO customerDAO;
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@WebMethod(exclude=true)
	public Customer custExample() {
		Customer customer = new Customer();
		customer.setName("osman");
		customer.setSurname("yay");
		List<Account> accounts = new ArrayList<>();
		Account account = new Account();
		account.setAccountDesc("test");
		account.setAccountType(EAccountType.TL);
		accounts.add(account);
		customer.setAccounts(accounts);
		return customer;
	}
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public int createCustomer(@WebParam(name="customer") Customer customer) {
		customerDAO.persistCustomer(customer);
		return 0;
	}
	
	@GET
	@Path("/list")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public CustomerList allCustomers() {
		CustomerList customerList = new CustomerList();
		customerList.setCustomers(customerDAO.getAllCustomers());
		return customerList;
	}
}
