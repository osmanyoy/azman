package com.allianz.training.ee.cdi;

import java.io.Serializable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.enterprise.concurrent.ManagedExecutors;
import javax.enterprise.concurrent.ManagedThreadFactory;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.inject.Named;
import javax.interceptor.Interceptors;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.w3c.dom.css.Counter;

import com.allianz.training.ee.cdi.inter.InterceptorImp;
import com.allianz.training.ee.cdi.inter.MyInterceptor;
import com.allianz.training.ee.ejb.AsyncEJB;

@Path("/cdi")
@RequestScoped
@Interceptors({InterceptorImp.class})
public class CdiRest implements Serializable{
	private static final long serialVersionUID = -2602412683653536673L;

	private int counter  = 0;
	
	@Resource
	private ManagedThreadFactory manThread;
	
	@Resource
	private ManagedExecutors executor;
	
	@Resource
	private ScheduledExecutorService ses;
	
	@Inject
	// @Named("v2")
	// @Named("xyz")
	// @ExecuteQualifier
	@Alternative
	private IExecute execute;
	
	@EJB
	private AsyncEJB async;
	
	@GET
	@MyInterceptor
	public String exec() throws Exception {
		Future<String> hello = async.hello();
		System.out.println("test kodu");
		System.out.println(hello.get());
		
		return execute.execute() + " : " + counter;
	}
}
