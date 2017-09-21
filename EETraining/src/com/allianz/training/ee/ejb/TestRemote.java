package com.allianz.training.ee.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class TestRemote
 */
@Stateless
@LocalBean
@Remote(TestRemoteRemote.class)
public class TestRemote implements TestRemoteRemote, TestRemoteLocal {

    /**
     * Default constructor. 
     */
    public TestRemote() {
        // TODO Auto-generated constructor stub
    }

}
