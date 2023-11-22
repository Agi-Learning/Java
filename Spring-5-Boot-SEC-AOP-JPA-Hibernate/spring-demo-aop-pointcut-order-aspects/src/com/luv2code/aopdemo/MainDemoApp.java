package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

//## Aspect-Oriented Programming (AOP) Control Aspect Order
//
//### Problem
//
// * How to control the order of advices being applied?
//
// MyLoggingDemoAspect
// 	-> beforeAddAccountAdvice
// 	-> performApiAnalyticsAdvice
// 	-> logToCloudAdvice
//
// * This order is undefined, So Basically Spring is pick on of them and run, So In your application control the order how these advice are executed thing have to the additional work 
//
// ### To Control Order
//
// * Refactor: Place advices in separate Aspects (Fine gain control)
// * Control order on Aspects using the @Order annotation
// * Guarantees order of when Aspects are applied
//
// ### Development Process
//
// 1. Refactor: Place advices in separate Aspects
// 2. Add @Order annotation to Aspects
// 
// #### Step 1 - Refactor: Place advices in separate Aspects
//
// Check Tab ->
//
// * So we gonna take an advices here, gonna break them up to separate Aspects, So MyLoggingDemoAspect gonna separate 3 aspects Fine setting the order as the aspects
//
//
// #### Step 2 - Add @Order annotation to Aspects
//
// * Control order on Aspects using the @Order annotation
//
// ```Java
// 	@Order(1)
// 	public class MyCloudLogAspect {
// 		...
// 	}
// ```
// * Guarantees order of when Aspects are applied 
// * Lower numbers have higher precedence 
//
// ### @Order
//
// * We want the following order:
// 1. MyCloudLogAspect
// 2. MyLoggingDemoAspect
// 3. MyApiAnalyticsAspect
//
// ### @Order annotation
// * Lower number have higher precedence
// 	* Range: Integer.MIN_VALUE to Integer.MAX_VALUE
// 	* Negative numbers are allowed
// 	* Does not have to be consecutive
// * Example with negative numbers
//
// ### @Order annotation
// * FAQ: What if aspects have the exact same @Order annotation?
//
// ```Java
// 	@Order(1)
// 	public class MyCloudLogAspect { ... }
// 	@Order(6)
// 	public class MyShowAspect { ... }
// 	@Order(6)
// 	public class MyFunnyAspect { ... }
// 	@Order(123)
// 	public class MyLoggingDemoAspect { ... }
// 	
// ``` 
// * The order at this point is undefined
// * Will still run AFTER MyCloudLogAspect and BEFORE MyLoggingDemoAspect


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
