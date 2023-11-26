package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

//## Aspect-Oriented Programming (AOP) @AfterReturning Advice 
//
//### @AfterReturning Advice - Interaction
//
//Check Tab ->
//
// * MainApp on left hand side on target obj always to right hand side and remember with AOP and method calls in u can preprocess @Before -> the target object code will execute and then the return coming back we can actually make use of new advice type @AfterReturning write code are execute after that method has been completed or after return value of data.
//
// ```Java
// 	TargetObject
// 	public void doSomeStuff() {
// 		... 
// 	}
// ```
//
// ### @AfterReturning Advice - Use Cases
//
// * Most common
// 	* logging, security, transactions 
// * Audit logging
// 	* who, what, when, where
// * Post-processing Data
// 	* Post process the data before returning to caller
// 	* Format the data or enrich the data (really cool but be careful)
//
// ### Example
// * Create an advice that will run after a method call (success execution)
//
// ### @AfterReturning Advice
//
// * This advice will run after the method call (success execution)
// ```Java
// 	@AfterReturning("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
// 	public void afterReturningFindAccountsAdvice(){
// 		System.out.println("Executing @AfterReturning advice");
// 	}
// ```
// * After executing advice do whatever, that's the basic layout very similar to at before itself for after return it runs after the method calls completely for successful execution.
//
// ### Access the Return Value
//
// * Need to access the return value of method called 
//
//```Java
//	@AfterReturning(
//		pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
//		returning="result")
//	public void afterReturningFindAccountsAdvice(
//		JoinPoint theJoinPoint, List<Account> result){
//		// Parameter name for return value, we gonna return list of account 
//		// Print out the results of the method call
//		System.out.println("\n===>>> result is: "+result);
//	}
//
//```
//* You can use ANY parameter name ... just stay consistent
//* As long as consistence in the aop only for aop level
//
//### Development Process - @AfterReturning
//
//1. Prep Work: Add constructors to Account class
//2. Add new method: findAccounts() in AccountDAO
//3. Update main app to call the new method: findAccounts()
//4. Add @AfterReturning advice
//
//## Aspect-Oriented Programming (AOP) @AfterReturning Advice - Modify Return Value 
//
//### Post-Process/Modify Data
//
// * And we have AccountDAO, So what we can do actually post-process the data and advice we actaully we modify the data before makes back to the actual call in the programs, So we can intercept the data and minipulating.
// * Calling program will get the modified result, 
//
// ###  Modify the Return Value
//
// ```Java
// 	ava
//	@AfterReturning(
//		pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
//		returning="result")
//	public void afterReturningFindAccountsAdvice(
//		JoinPoint theJoinPoint, List<Account> result){
//		
//		// modify "result" list: add, remove, update, etc...
//
//		if (!result.isEmpty()) {
//			Account tempAccount = result.get(0);
//			tempAccount.setName("Daffy Duck");
//		}
//	}
// ```
// ### Calling program
//
// ```Java
// 	// call method to find the accounts
// 	List<Account> theAccounts = theAccountDAO.findAcconts();
// ```
// * this is really cool but be careful
// * Imageine you making this method call, You have no idea AOP Aspects and running the background, this system broken everytime i call account find account it returning "daff Duck" for the first account that is wrong 
// * Your development team should be aware of AOP being used in app, weired result being careful effectivly aspect advice basically intercept in the call and making some changes here so all of these are spie networks using package on amazon before made it you some one grab that package opened it up and did something to it, you can never know that particular package modify it.

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		// read spring config java class, No xml
		AnnotationConfigApplicationContext context = 
			new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		AccountDAO theAccountDAO = context
				.getBean("accountDAO", AccountDAO.class);

		// call method to find the accounts
		List<Account> theAccounts = theAccountDAO.findAccounts(false);
		
		// display the accounts
		System.out.println("\n\nMain Program: AfterReturningDemoApp");
		System.out.println("----");
		
		System.out.println(theAccounts);
		
		System.out.println("\n");
		
		// close the context
		context.close();
	}
}
