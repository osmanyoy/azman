package com.allianz.training.ee.ejb;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;

import com.allianz.training.ee.rest.Employee;

/**
 * Session Bean implementation class TrainingDAO
 */
@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TrainingDAO {

	@Resource
	private EJBContext context;

	@Resource
	private UserTransaction ut;

	@PersistenceContext(unitName = "EETraining")
	private EntityManager manager;

	/**
	 * Default constructor.
	 */
	public TrainingDAO() {
		// TODO Auto-generated constructor stub
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void writeEmployee(Employee employee) throws Exception {
		manager.persist(employee);
	}

	@TransactionAttribute(TransactionAttributeType.NEVER)
	public List<Employee> getAllEmployees() {
		TypedQuery<Employee> createQuery = manager.createNamedQuery("employeeSelectAll", Employee.class);
		List<Employee> resultList = createQuery.getResultList();
		return resultList;
	}

	@TransactionAttribute(TransactionAttributeType.NEVER)
	public List<Employee> getAllEmployeesByName(String name) {
		TypedQuery<Employee> createQuery = manager.createNamedQuery("employeeSelectAllByNameParameter",
				Employee.class);
		createQuery.setParameter("nm", name);
		List<Employee> resultList = createQuery.getResultList();
		return resultList;
	}

	@TransactionAttribute(TransactionAttributeType.NEVER)
	public List<Employee> getAllEmployeesByNameNative(String name) {
		 Query createNativeQuery = manager.createNamedQuery("selectFromEmployee",
				Employee.class);
		 createNativeQuery.setParameter("nm", name);
		List<Employee> resultList = createNativeQuery.getResultList();
		return resultList;
	}

	@TransactionAttribute(TransactionAttributeType.NEVER)
	public List<Employee> getAllEmployeesByName2(String name) {
		TypedQuery<Employee> createQuery = manager.createNamedQuery("employeeSelectAllByNameIndex", Employee.class);
		createQuery.setParameter(1, name);
		List<Employee> resultList = createQuery.getResultList();
		return resultList;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void updateEmployee(Employee employee) {
		manager.merge(employee);
	}

}
