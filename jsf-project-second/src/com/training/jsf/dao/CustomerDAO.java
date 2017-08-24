package com.training.jsf.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.training.jsf.model.Customer;

@Named
@ApplicationScoped
public class CustomerDAO {

	@PersistenceUnit(name = "jsf-project-second")
	private EntityManagerFactory entityManagerFactory;

	@Transactional
	public void saveCustomer(final Customer customer) {

		EntityManager enManager = this.entityManagerFactory.createEntityManager();

		enManager.joinTransaction();
		enManager.persist(customer);
		enManager.close();

	}

	@Transactional
	public void deleteCustomer(final Customer customer) {

		EntityManager enManager = this.entityManagerFactory.createEntityManager();

		enManager.joinTransaction();
		Customer merged = enManager.merge(customer);

		enManager.remove(merged);
		enManager.close();

	}

	public List<Customer> getAllCustomers() {
		EntityManager enManager = this.entityManagerFactory.createEntityManager();
		Query createQuery = enManager.createQuery("select c from Customer c");
		List<Customer> resultList = createQuery.getResultList();
		return resultList;
	}

	@Transactional
	public void updateCustomer(final Customer customer) {
		EntityManager enManager = this.entityManagerFactory.createEntityManager();

		enManager.joinTransaction();
		enManager.merge(customer);

		enManager.close();

	}

}
