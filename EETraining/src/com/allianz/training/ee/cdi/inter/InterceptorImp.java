package com.allianz.training.ee.cdi.inter;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.jboss.logging.Logger;

@Interceptor
@MyInterceptor
public class InterceptorImp {
	private Logger loger = Logger.getLogger(InterceptorImp.class);

	@AroundInvoke
	public Object func(InvocationContext context) {
		System.out.println("Method baslamadan once " + context.getMethod().getName());
		if (loger.isInfoEnabled()) {
			loger.info("Method baslamadan once " + context.getMethod().getName());
		}
		try {
			Object proceed = context.proceed();
			System.out.println("Method dan sonra " + context.getMethod().getName());
			if (loger.isInfoEnabled()) {
				loger.info("Method dan sonra " + context.getMethod().getName());
			}
			return proceed;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
}
