package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;

//## Aspect-Oriented Programming (AOP): @Around Advice
//
//### Advice - Interaction
//
//* Basically we have target object with around advice we can actually execute code before we make the method call and then we can also give the result after that method call is complete 
//* @Around: Like a combination of @Before and @After, But gives you more fine-grained control over the process. 
//
//### @Around Advice -Use Cases
//
//* Most common: logging, auditing, security 
//* Pre-processing and post-processing data
//* Instrumentation / profiling code
//	* How long does it take for a section of code to run? 
//* Managing exceptions
//	* Swallow / handle / stop exceptions
//
//### Our FortuneService Example - Revisited
//### Sequence Diagram
//Check Tab->
//
//### Proceeding JoinPoint
//
//* When using @Around advice 
//* You will get a reference to a "proceeding join point"
//* This is a handle to the target method 
//* Your code can use the proceeding join point execute target method
//
//### Example
//
//* Create an advice for instrumentation / profiling code
//	* How long does it take for a section of code to run? ( A code simple, may be return hardcode string, it may take to a DB, may take to remoter web service, or some other cloud service, let me find out how lang it take to this to run.)
//
//Check Tab -> 
//
//### @Around Advice
//
//```Java
//	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
//	public Object aroundGetFortune(
//		ProceedingJoinPoint theProceedingJoinPoint) throws Throwable { // Handle to target method
//		// get begin timestamp
//		long begin = System.currentTimeMillis();
//
//		// now, let's execute the method
//		Object result = theProceedingJoinPoint.proceed();
//		// Handle to target method
//		// Execute the target method
//
//		// get end timestamp
//		long end = System.currentTimeMillis();
//
//		// compute duration and display it
//		long duration = end - begin;
//		System.out.println("\n=========> Duration: " + duration + " milliseconds.");
//		return result;
//	}
//```

public class AroundDemoApp {

	public static void main(String[] args) {
		// read spring config java class, No xml
		AnnotationConfigApplicationContext context = 
			new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		TrafficFortuneService theFortuneService = context
				.getBean("trafficFortuneService", TrafficFortuneService.class);

		System.out.println("\nMain Porgram: AroundDemoApp");
		
		System.out.println("Calling getFortune");
		
		String data = theFortuneService.getFortune();
		
		System.out.println("\nMy fortune is: "+data);
		
		System.out.println("Finished");
		
		// close the context
		context.close();
	}
}
