package com.allianz.training.ee.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.allianz.training.ee.rest.Employee;

/**
 * Session Bean implementation class TrainingDAO
 */
@Stateless
@LocalBean
public class TrainingDAO {

	@PersistenceContext(unitName="EETraining")
	private EntityManager manager;

	/**
     * Default constructor. 
     */
    public TrainingDAO() {
        // TODO Auto-generated constructor stub
    }
    
    public void writeEmployee(Employee employee) {
    	manager.persist(employee);
    }
}





