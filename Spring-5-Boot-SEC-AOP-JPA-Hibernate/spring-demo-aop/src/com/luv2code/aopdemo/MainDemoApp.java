package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

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

public class MainDemoApp {

	public static void main(String[] args) {
		// read spring config java class, No xml
		AnnotationConfigApplicationContext context = 
			new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		AccountDAO theDAO = context.getBean("accountDAO", AccountDAO.class);

		// call the bussiness method
		theDAO.addAccount();

		// do it againg!
		System.out.println("\n let's call it again!");
		
		// call the business method again
		theDAO.addAccount();
		
		// close the context
		context.close();

	}

}
