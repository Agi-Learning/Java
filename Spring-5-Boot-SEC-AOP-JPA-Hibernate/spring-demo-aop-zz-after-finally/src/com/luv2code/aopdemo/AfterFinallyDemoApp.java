package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

//## Aspect-Oriented Programming (AOP): @After Advice
//
//* Runs after a method is completed. Regardless of outcome / exceptions
//* success or failure this code will always run. And this works Just like "finally" block
//* @After will run for success or failure (finally)
//
//### Sequence Diagram
//* @After will execute before @AfterThrowing
//Check Tab ->
//
//### @After Advice - Use Cases
//* Log the exception and/or perform auditing
//* Code to run regardless of method outcome
//* Encapsulate this functionality in AOP aspect for easy reuse
//
//### @After Advice
//* This advice will run after the method (finally ...success/failure)
//
//```Java
//	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
//	public void afterFinallyFindAccountsAdvice() {
//		System.out.println("Executing @After (finally) advice");
//	}
//```
//### @After Advice - Tips
//* The @After advice does not have access to the exception
//	* If you need exception, then use @AfterThrowing advice
//* The @After advice should be able to run in the case of success or error
//	* Your code should not depend on happy path or an exception
//	* Logging / auditing is the easiest case here
//
//### Development Process - @After
//
//1. Prep work
//2. Add @After advice
//3. Test for failure/exception case
//4. Test for success case

public class AfterFinallyDemoApp {

	public static void main(String[] args) {
		// read spring config java class, No xml
		AnnotationConfigApplicationContext context = 
			new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		AccountDAO theAccountDAO = context
				.getBean("accountDAO", AccountDAO.class);

		// call method to find the accounts
		List<Account> theAccounts = null;
		
		try {
			// add a boolean flag to simulate exceptions
			boolean tripWire = false;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		}catch(Exception exc) {
			System.out.println("\n\nMain Program ... caught exception: " + exc);
		}
		
		
		// display the accounts
		System.out.println("\n\nMain Program: AfterReturningDemoApp");
		System.out.println("----");
		
		System.out.println(theAccounts);
		
		System.out.println("\n");
		
		// close the context
		context.close();
	}
}
