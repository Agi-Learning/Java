package com.luv2code.aopdemo;

import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

//## Aspect-Oriented Programming(AOP) Overview
//Check Tab ->
//### New Requirement - Logging
//
//* Need to add logging to our DAO methods
//	* Add some logging statements before that start of the method
//
//* Possibly more places ... but get started on the ASAP!
//
//```Java
//	public void addAccount(Account theAccount, String userId){
//		// add code for logging
//		// add code for security check
//		Session currentSession = sessionFactory.getCurrentSession();
//		currentSession.save(theAccount);
//	}
//```
//* Need to add security code to our DAO
//	* Make sure user is authorized before running DAO method
//
// We don't feel 100% comfortable 
//
// #### By the way
//
// * Let's add it to all of our layers...
//
// #### Two Main Problems
//
// ##### Code Tangling
// 	* For a given method: addAccount(...)
// 	* We have logging and security code tangled in  
// ##### Code Scattering
// 	* If we need to change logging or security code
// 	* We have to update ALL classes
//
// ### Other possible solutions?
//
// ##### Inheritance?
// 	* Every class would need to inherit from a base class
// 	* Call all classes extends from your base class? ... plus no multiple inheritance 
//
// ##### Delegation?
// 	* Classes would delegate logging, security calls
// 	* Still would need to update classes if we wanted to
// 		* add/remove logging or security 
// 		* add new feature like auditing, API management, instrumentation
//
// ### Aspect-Oriented Programming
//
// * Programming technique based on concept of an Aspect
// * Aspect encapsulates cross-cutting logic (Cross-cutting Concerns)
// * 'Concern' means logic/functionality 
//
// Check Tab ->
//
// * Its like infarastructure code, So in our project we are gonna need to have login, security layers different levels of applications so we can basically take that logging code encasulated reusable module or class and then we can have the code we called when make apropreiate calls to account controller or product controller whatever based on different area of systems. 
//
// #### Aspects
//
// * Aspect can be reused at multiple locations 
// * Sample aspect/class ... applied based on configuration
//
// Check Tab ->
//
// #### AOP Solution
//
// * Apply the Proxy design pattern
//
// Check Tab ->
//
// Now the main application no idea of AOP, main app has no idea for any aspects, So this is making a phone call to a firend pickup phone you make a phone call to your friend but behind the scenes your phone has been monitor, We can take an action accross whatsoever this is kind of spie network So this all happens behind the scenes 
//
// #### Benefits of AOP
//
// * Code for Aspect is defined in a single class
// 	* Much better than being scattered everywhere
// 	* Promotes code reuse and easier to change
//
// * Business code in your application is cleaner
// 	* Only applies to business functionality: addAccount
// 	* Reduces code complexity
//
// * Configurable
// 	* Based on configuration, apply Aspects selectively to different parts of app
// 	* No need to make changes to main application code... very important!
//
// #### Additional AOP Use Cases
//
// * Most common
// 	* Logging, security, transactions
//
// * Audit logging
// 	* who, what, when, where
//
// * Exception handling
// 	* log exception and notify DevOps team via SMS/email
//
// * API Management
// 	* how many times has a method been called user
// 	* analytics: what are peak times? What is average load? Who is top user?
//
//
// #### AOP: advantages and disadvantages
//
// ##### Advantages
// 
// * Reusable modules
// * Resolve code tangling
// * Resolve code scatter
// * Applied selectively based on configuration 
//
// ##### Disadvantages
//
// * Too many aspects and app flow is hard to follow 
// * Minor performance cost for aspect execution (run-time weaving)
//
// ### AOP Terminology
//
// * Aspect: module of code for a cross-cutting concern (logging, security, ...)
// * Advice: What action is taken and when it should be applied
// * Join Point: When to apply code during program execution 
// * Pointcut: A predicate expression for where advice should be applied
//
// #### Advice Types
//
// * Before advice: run before the method 
// * After finally advice: run after the method (finally)
// * After returning advice: run after the method (success execution)
// * After throwing advice: run after method (if exception thrown)
// * Around advice: run before and after method 
//
// #### Weaving
//
//  * Connecting aspects to target objects to create an advised object
//  * Different types of weaving
//  	* Compile-time, load-time or run-time 
//  * Regarding performance: run-time weaving is the slowest 
//
// #### AOP Frameworks
//
// * Two leading AOP Frameworks for Java 
//
// 1. Spring AOP
// 2. AspectJ
//
// ##### Spring AOP Support
//
// * Spring provides AOP support 
// * Key component of Spring
// 	* Security, transactions, caching etc.
// * Uses run-time weaving of aspects 
//
// ###### Advantages
// * Simpler to use than AspectJ
// * Uses Proxy pattern
// * Can migrate to AspectJ when using @Aspect annotation
//
// ###### Disadvanges
// * Only supports method-level join points
// * Can only apply aspects to beans created by Spring app context
// * Minor performance cost for aspect execution (run-time weaving)
//
//
// ##### AspectJ
// * Original AOP framework, released in 2001
// 	* www.eclipse.org/aspectj
// * Provides complete support for AOP
// * Rich support for
// 	* join points: method-level, constructor, field
// 	* code weaving: compile-time, post compile-time and load-time
//
// ###### Advantages
// * Support all join points 
// * Works with any POJO, not just beans from app context
// * Faster performance compared to Spring AOP
// * Complete AOP support
//
// ###### Disadvanges
// * Compile-time weaving requires extra compilation step
// * AspectJ pointcut syntax con become complex
//
// ##### Comparing Spring AOP and AspectJ
//
// * Spring AOP only supports
// 	* Method-level join points
// 	* Run-time code weaving (slower than AspectJ)
// * AspectJ supports 
// 	* join points: method-level, constructor, field
// 	* Weaving: compile-time, post compile-time and load-time
//
// * Spring AOP is a light implementation of AOP
// * Solves common problems in enterprise applications. 
//
// * My recommendation
// 	* Start with Spring AOP  ... easy to get started with
// 	* If you have complex requirements than move to AspectJ
//
//
// ##### Additional Resources
//
// * Spring Reference Manual: www.spring.io
// * AspectJ in Action
// 	* by Raminvas Ladad
// * Aspect-Oriented Development with Use Cases
// 	* by Ivar Jacobson and Pan-wei Ng
//
// ##### Our Spring AOP Roadmap
//
// * Create Aspects
// * Develop Advices
// 	* Before, After returning, After throwing,
// 	* After finally, Around
// * Create Pointcut expressions
// * Apply it to our big CRM project (Spring MVC + Hibernate)
//
// ### @Before Advice - Interaction
//
// * Before advice we have the main application calling target object. Call a method like targetObj.doSomeStuff() We want have own custom code execute before the actual methods, That method do some stuff we want a inject our own custom code that our logging and security work, that is basic idea putting in logging advice, This code will run before actual method executes.
//
// #### Advice - Interaction
//
// * We like to do basically add some run before this method, In order to do that add @Before this allow us to inject our own custom code that will execute before doSomeStuff method executes. And then likewise we can also make use of the @AfterReturning will actually show u allow u to inject custom code after the method returns So you can imagine logging log some data before log 
//
// #### @Before Advice - Use Cases
//
// * Most common
// 	* logging, security, transactions ( log data, performs some security, you can make use of transaction think about it add before, after u could start a transaction before the method and then once the method is finished after returning u could commit the transaction, In facts spring does behind the scene if we call that add transaction actully we can do some of the previous vids Spring is using AOP behind the scences to strat the transaction for you  )
// * Audit logging
// 	* who, what, when, where 
// * API Management
// 	* how many times has a method been called user
// 	* analytics: what are peak times? What is average load? Who is top user?
//
// #### Adding AspectJ JAR File
//
// * Need to download AspectJ JAR file 
// * Even though we are using Spring AOP ... still need AspectJ JAR file 
// * Why?
// 	* Spring AOP uses some of the AspectJ annotations 
// 	* Spring AOP uses some of the AspectJ classes
//
//#### Development Process - @Before
//
//1. Create target object: AccountDAO
//2. Create Spring Java Config class 
//3. Create main app
//4. Create an Aspect with @Before advice
//
//##### Step 1: Create Target Object: AccountDAO
//
//
//```Java
//	@Component
//	public class AccountDAO {
//		public void addAccount(){
//			System.out.println("DOING MY db WORK: ADDING AN ACCOUNT");
//		}
//	}
//```
//
//##### Step 2: Create Spring Java Config class
//
//```Java
//	@Configuration
//	@EnableAspectJAutoProxy // Spring AOP Proxy Support
//	@ComponentScan("com.luv2code.aopdemo") // Component scan for components and aspects Recurse packages all the way for down to all sub directory
//	public class DemoConfig {
//
//	}
//```
//
//##### Step 3: Create main app
//
//```Java
//	public class MainDemoApp {
//		// read spring config java class
//		AnnotationConfigApplicationContext context = 
//			new AnnotationConfigApplicationContext(DemoConfig.class);
//
//		// get the bean from spring container
//		AccountDAO theDAO context.getBean("accountDAO", AccountDAO.class);
//
//		// call the bussiness method
//		theDAO.addAccount();
//
//		// close the context
//		context.close();
//	}
//
//```
//
//##### Step 3: Create an Aspect with @Before advice
//
//```Java
//	@Aspect
//		// listen in on communication behind the scenes Aspect annotations 
//	@Component
//	public class MainDemoApp {
//		@Before("execution(public void addAccount())")
//		public void beforeAddAccountAdvice(){ //The annotated method Can have any name
//			// Run this code BEFORE - target object method: "public void addAccount()"
//			System.out.println("Executing @Before advice an addAccount()"); // Add our custom code
//		}
//	}
//```
//
//##### Best Practices: Aspect and Advices
//
//* Keep the code small
//* Keep the code fast
//* Don't perform any expensive / slow operations
//* Get in and out as QUICKLY as possible

//## AOP Pointcut expression
//
//### AOP Terminology
//
//* Pointcut: A predicate expression for where advice should be applied
//
//### Pointcut Expression Language
//
//* Spring AOP uses AspectJ's pointcut expression language
//* We will start with execution pointcuts
//	* Applies to execution of methods.
//
//### Match on Method Name 
//#### Pointcut Expression Language
//
// * Will use this basically define the predicate this actually Match on given method and there is number of different pattern we can apply. so let's go an break it down.
// 
// ```Java
// 	execution(modifiers-pattern? retun-type-pattern declaring-type-pattern? method-name-pattern(param-pattern) throws-pattern?)
// ```
// * find the predicate to actually match on given method, there is an number of diff patterns we can apply 
// * first start with the modifier patterns then return type pattern, next we have the clearing type pattern basically what's the class name of the type that gonn use method the we have the actaul method name patterns you can give the actual name itself, and paramethers types to match and then fianlly throws get pattern. 
//
// * The pattern is optional if it has "?"
// * Patterns can also use wildcards 
// 	* For the patterns, can use wildcard: * (match on everything)
//
// ##### Pointcut Expression Example
//
// ###### Match on method names
// * Match only addAccount() method in AccountDAO class 
//
// @Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())") -> It's all from matching execution calls for a given method (Modifier, Return type, Declaring type, Method)
// 
// * Match any addAccount() method in any class
//
// @Before("execution(public void addAccount()"), -> any call to add account method to any class 
//
// ###### Match on method names (using wildcards)
//
// * Match methods starting with add in any class
//
// @Before("execution(public void add*())") -> The Modifier is public and return type is void and the method is add* then you need to calls the method advice 
//
// * Match methods starting with processCreditCard in any class
//
//@Before("execution(public VerificationResult processCreditCard*())") -> The Modifier publics the return type of VerificationResult and then actual method is processCreditCard* So here any method returns of verifictaionResult public That has processCreditCard then will apply our advice.
//
// * Use wildcards on modifier and return type
//
// @Before("execute("* * processCreditCard*()") -> On matching on wildcard expression
//
//  * Modifier is optional ... so you don't have to list it
//
//  @Before("execution(* processCreditCard*())") 
//
//  ###### Match method named: "addAccount" in any class 
//
//  * Whenever calling the method on account it will execute before method 
//
//  ###### Match only: AccountDAO.addAccount 
//
//  * Only account DAO only specific matches one name class 
//
//  ###### Match method starting with "add" in any class
//
//  @Before("execution(public void add*())")
//
//  ###### Match method with based on Return Type
//
// ###### Parameter Pattern Wildcards
//
// * For param-pattern
// 	* () - matches a method with no arguments
// 	* (*) - matches a method with one argument of any type 
// 	* (..) - matches a method with 0 or more arguments of any type
//
// ###### Match on method parameters
// 	* Match addAccount methods with no arguments
//
// @Before("execution(* addAccount())") -> 
//
// ###### Match on method parameters
// 	* Match addAccount methods that have Account param
//
// @Before("execution(* addAccount(com.luv2code.aopdemo.Account))")
// 	* Full Qulified class name of the account class So this is only match if you call in addAccount method and you pass an account object 
//
// ###### Match on method parameters (using wildcards)
//
// 	* Match addAccount methods with any number of arguments
//
// @Before("execution((* addAccount(..))") 
//
// ###### Match on methods in a package 
// 	* Match any method in our DAO package: com.luv2code.aopdemo.dao
//
// @Before("execution(* com.luv2code.aopdemo.dao.*.*(..))") 

public class MainDemoApp {

	public static void main(String[] args) {
		// read spring config java class, No xml
		AnnotationConfigApplicationContext context = 
			new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		AccountDAO theDAO = context.getBean("accountDAO", AccountDAO.class);

		// get membership bean from spring container
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
				
		// call the bussiness method
//		theDAO.addAccount();

		Account myAccount = new Account();
		
//		@Before("execution(* add*(com.luv2code.aopdemo.Account))")
		// this only match addAccount parameter type eaither bottom will not match because
		theDAO.addAccount(myAccount, true);
		// Note this I haven't modified expression it's only one parameter.
		// Let's call our new methods
		theDAO.doWork();
		
		
		// call the membership business method 
		// Did NOT match on MembershipDAO because of return type: boolean
		theMembershipDAO.addSillyMember(); // It will not match on
		theMembershipDAO.goToSleep();
		// Match on both of these in match package 
		
//		// do it againg!
//		System.out.println("\n let's call it again!");
//		
//		// call the business method again
//		theDAO.addAccount();
		
		// close the context
		context.close();

	}

}
