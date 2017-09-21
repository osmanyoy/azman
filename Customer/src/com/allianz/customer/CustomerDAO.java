package com.allianz.customer;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Session Bean implementation class CustomerDAO
 */
@Stateless
@LocalBean
public class CustomerDAO {

    @PersistenceContext(unitName="Customer")
    private EntityManager entityManager;
	
	/**
     * Default constructor. 
     */
    public CustomerDAO() {
        // TODO Auto-generated constructor stub
    }
    
    public void persistCustomer(Customer customer) {
    	entityManager.persist(customer);
    }
    
    public List<Customer> getAllCustomers(){
    	TypedQuery<Customer> createQuery = entityManager.createQuery("select c From Customer c", Customer.class);
    	return createQuery.getResultList();
    }

}
