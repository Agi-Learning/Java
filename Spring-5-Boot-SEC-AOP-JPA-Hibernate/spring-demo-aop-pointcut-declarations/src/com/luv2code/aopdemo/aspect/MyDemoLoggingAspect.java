package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect 
@Component
public class MyDemoLoggingAspect {
	// this is where we add all of our related advices for logging
	
	// Let's start with an @Before advice

	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}

//	@Before("forDaoPackage()")
//	public void beforeAddAccountAdvice(){
//		...
//	}
	
	@Before("forDaoPackage()") // Apply pointcut declaration advice
	public void beforeAddAccountAdvice(){ 
		System.out.println("\n ===> Executing @Before advice an addAccount()");
	}
	// actual declaration of pointcut so that have DAO package so names match up instead of bringing the long head expression u simply make use of the pointcut declaration reference. and also reuse later on advice 
	@Before("forDaoPackage()")
	public void performApiAnalytics(){
		System.out.println("\n ===> Performing API analytics");
	}
	
}







