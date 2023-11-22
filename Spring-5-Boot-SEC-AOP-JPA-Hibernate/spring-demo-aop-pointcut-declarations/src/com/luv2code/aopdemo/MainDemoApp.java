package com.luv2code.aopdemo;

import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

//## Aspect-Oriented Programming (AOP) Pointcut Declarations
//
//### Problem
//
//* How can we reuse a pointcut expression? 
//	* Want to apply to multiple advices in my AOP Aspect
//
//### Possible Solution
//
//* Could just do the old copy/paste method ... yuk!
//
//### Ideal Solution
//
//* Create a pointcut declaration once
//* Apply it to multiple advices 
//
//### Development Process
//
//1. Create a pointcut declaration
//2. Apply pointcut declaration to advice(s)
//
//
//#### Step 1 - Create Pointcut Declaration
//
//* Create a pointcut declaration once
//
//```Java
//	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
//	private void forDaoPackage(){}
//```
//* Name of pointcut declaration and can have ANY name 
//
//####  Step 2 - Apply pointcut declaration to advice(s)
//
//```Java
//	@Aspect
//	@Component
//	public class MyDemoLoggingAspect {
//		@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
//		private void forDaoPackage() {}
//
//		@Before("forDaoPackage()")
//		public void beforeAddAccountAdvice(){
//			...
//		}
//		// actual declaration of pointcut so that have DAO package so names match up instead of bringing the long head expression u simply make use of the pointcut declaration reference. and also reuse later on advice 
//		@Before("forDaoPackage()")
//		public void performApiAnalytics(){
//			...
//		}
//	}
//```
//
//### Benefits of Pointcut Declarations
//
//* Easily reuse pointcut expressions
//* Update pointcut in one location
//* Can also share and combine pointcut expression (coming up later)
//
//## Aspect-Oriented Programming (AOP) Combine Pointcut
//
//### Problem
//
//* How to apply multiple pointcut expressions to single advice? 
//* Execute an advice only if certain contitions are met 
//
//For example
//	* All methods in a package EXCEPT getter/setter methods
//
//### Combining Pointcut Expressions
// 
// * Combine pointcut expressions using logic operators
// 	* AND (&&)
// 	* OR (||)
// 	* NOT (!)
// * Works like an "if" statement
// * Execution happens only if it evaluates to true 
//
// ```Java
// 	@Before("expressionOne() && expressionTwo()")
// 	@Before("expressionOne() || expressionTwo()")
// 	@Before("expressionOne() && !expressionTwo()")
// ```
//
// #### Example:
// * All methods in a package EXCEPT getter/setter methods
//
// ### Development Process
// 1. Create a pointcut declarations
// 2. Combine pointcut declarations
// 3. Apply pointcut declaration to advice(s)
//
// #### Step 1 - Create Pointcut Declaration
// #### Step 2 - Combine pointcut declarations
// ```Java
// 	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
// 	private void forDaoPackage() {}
//
// 	// create pointcut for getter methods
// 	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
// 	private void getter() {} 
// 	// Name of pointcut declaration
// 	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
// 	private void setter() {} 
// 	// combine pointcut: include package ... exclude getter/setter
// 	@Pointcut("forDaoPackage() && !(getter() || setter())")
// 	private void forDaoPackageNoGetterSetter() {} 
// 	// Name of pointcut declaration
// ```
// #### Step 3 - Apply pointcut declaration to advice(s)
//
// ```Java
// 	// combine pointcut: include package ... exclude getter/setter
// 	@Pointcut("forDaoPackage() && !(getter() || setter())")
// 	private void forDaoPackageNoGetterSetter() {}
//
// 	@Before("forDaoPackageNoGetterSetter()")
// 	public void beforeAddAccountAdvice()
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
		theDAO.addAccount(myAccount, true);
		theDAO.doWork();
		
		
		// call the membership business method 
		theMembershipDAO.addSillyMember(); // It will not match on
		theMembershipDAO.goToSleep();
		
		// close the context
		context.close();
	}
}
