package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

//## Aspect-Oriented Programming (AOP) Reading Method Arguments with JoinPoints
//
//### Problem
// * When we are in an aspect (ie for logging)
// 	* How can we access method parameters?
// ```Java MainDemoApp.java
// 	// call the business method
// 	Account myAccount = new Account();
// 	theAccountDAO.addAccount(myAccount, true);
// ```
//
// ### Development Process
// 1. Access and display Method Signature
// 2. Access and display Method Arguments
//
// ### 1 - Access and display Method Signature
//
// ```Java
// 	@Before("...")
// 	public void beforeAddAccountAdvice(JoinPoint theJoinPoint){
// 		// JoinPoiny hsd metadata about method call 
//
// 		// display the method signater
// 		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
//
// 		System.out.println("Method: "+ methodSig);
// 	}
// ```
//
// ### Step 2 - Access and display Method Arguments
//
// ```Java
// 	@Before("...")
// 	public void beforeAddAccountAdvice(JoinPoint theJoinPoint){
// 		// display method arguments
//
// 		// get args
// 		Object[] args = theJoinPoint.getArgs();
//
// 		// loop thru args
// 		for(Object tempArg:args){
// 			System.out.println(tempArg);
// 		}
// 	}
// ```

public class MainDemoApp {

	public static void main(String[] args) {
		// read spring config java class, No xml
		AnnotationConfigApplicationContext context = 
			new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		AccountDAO theDAO = context
				.getBean("accountDAO", AccountDAO.class);

		// get membership bean from spring container
		MembershipDAO theMembershipDAO = context
				.getBean("membershipDAO", MembershipDAO.class);
				
		// call the bussiness method
		Account myAccount = new Account();
		myAccount.setName("Madhu");
		myAccount.setLevel("Platinum");
		theDAO.addAccount(myAccount, true);
		theDAO.doWork();
		
		// call the accountdao getter/setter method
		theDAO.setName("foobar");
		theDAO.setServiceCode("silver");
		
		// call the membership business method 
		theMembershipDAO.addSillyMember(); 
		theMembershipDAO.goToSleep();
		
		// close the context
		context.close();
	}
}
