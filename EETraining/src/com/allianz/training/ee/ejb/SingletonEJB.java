package com.allianz.training.ee.ejb;

import javax.ejb.DependsOn;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * Session Bean implementation class SingletonEJB
 */
@Startup
// @DependsOn({"myEjb"})
@Singleton
@LocalBean
public class SingletonEJB {

    /**
     * Default constructor. 
     */
    public SingletonEJB() {
        // TODO Auto-generated constructor stub
    }

}
