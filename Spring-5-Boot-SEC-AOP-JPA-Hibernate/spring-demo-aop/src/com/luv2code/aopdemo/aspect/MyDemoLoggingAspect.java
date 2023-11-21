package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect 
@Component
public class MyDemoLoggingAspect {
	// this is where we add all of our related advices for logging
	
	// Let's start with an @Before advice

	// Fully qualified class name. Will only match on addAccount for this specific class
    // @Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
    // @Before("execution(public void updateAccount())")
	// @Before advice is never called because no calls to: updateAccount();
	// @Before("execution(public void add*())")
	// Will only match on "Void" Return Type for add* methods
	// @Before("execution(void add*())")
	// Match method with ANY Return Type - use wildcards
	// @Before("execution(* add*())")
	// @Before("execution(* add*(com.luv2code.aopdemo.Account))")
	// Root cause: must use fully qualified classname 
	// @Before("execution(* add*(Account))") // Qualified class
	// @Before("execution(* add*(com.luv2code.aopdemo.Account, ..))")
	// @Before("execution(* add*(..))") // Any parameters
	@Before("execution(* com.luv2code.aopdemo.dao.*.*(..))") // Match methods in a package
	public void beforeAddAccountAdvice(){ 
		System.out.println("\n ===> Executing @Before advice an addAccount()");
	}
	
}







