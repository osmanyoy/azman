package com.allianz.training.ee.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.allianz.training.ee.rest.Employee;

/**
 * Session Bean implementation class SessionEJB
 */
@Stateful
@LocalBean
public class SessionEJB {
	
	private List<String> liste = new ArrayList<>();
	
	@Resource(lookup="java:jboss/datasources/ExampleDS")
	private DataSource ds;
	
	@EJB
	private TrainingDAO trainingDAO;
	

    /**
     * Default constructor. 
     */
    public SessionEJB() {
    	try {
    		InitialContext initialContext = new InitialContext();
    		DataSource ds = (DataSource)initialContext.lookup("java:jboss/datasources/ExampleDS");
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
    
    @PostConstruct
    public void Init() {
    	List<Employee> allEmployees = trainingDAO.getAllEmployees();
    	for (Employee employee : allEmployees) {
    		liste.add(employee.getName());
		}
    }
    
    @PreDestroy
    public void destroy() {
    	
    }

    @Remove
    public void remove() {
    	
    }
}
