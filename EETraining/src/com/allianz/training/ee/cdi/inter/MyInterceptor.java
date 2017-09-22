package com.allianz.training.ee.cdi.inter;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.inject.Qualifier;
import javax.interceptor.InterceptorBinding;

@Qualifier
@InterceptorBinding
@Retention(RUNTIME)
@Target({ TYPE, FIELD, METHOD })
public @interface MyInterceptor {

}
