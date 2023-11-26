package com.luv2code.aopdemo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;

//## Aspect-Oriented Programming (AOP): @Around Advice - Handle Exception
//
//### ProceedingJoinPoint - Revisited
//
//* For an exception thrown from proceeding join point
//	* You can handle / swallow / stop the exception
//	* Or you can simply rethrow the exception
//* This gives you fine-grained control over how the target method is called 
//* Main App will never know exception happened 
//
//### Handle Exception
//
//```Java
//	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
//	public Object aroundGetFortune(
//		ProceedingJoinPoint theProceedingJoinPoint) throws Throwable { 
//
//		Object result = null;
//
//		try {
//			// let's execute the method
//			result = theProceedingJoinPoint.proceed();
//		} catch(Exception exc){
//			// log exception
//			System.out.println("@Around advice: We have a problem "+exc);
//
//			// handle and give default fortune ... use this approach with caution
//			result = "Nothing exciting here. Move along!";
//			// Give default fortune
//		}
//		return result;9
//	}
//```
//
//* Calling program will never know exception happened, becaus we handle the exception we assigned a value to results and then we will returning that result to the calling program.
//
//### Development Process - @Around Exception
//
//1. Prep work
//2. Add trip wire to simulate an exception
//3. Modify @Around advice to handle exception
//
//## Aspect-Oriented Programming (AOP): @Around Advice - Rethrow Exception
//
//### ProceedingJoinPoint - Revisited
//
//* For an exception thrown from proceeding join point
//	* You can handle / swallow / stop the exception
//	* Or you can simply rethrow the exception
//
//### Rethrow Exception
//
// ```Java
//	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
//	public Object aroundGetFortune(
//		ProceedingJoinPoint theProceedingJoinPoint) throws Throwable { 
//
//		Object result = null;
//
//		try {
//			// let's execute the method
//			result = theProceedingJoinPoint.proceed();
//		} catch(Exception exc){
//			// log exception
//			System.out.println("@Around advice: We have a problem "+exc);
//
//			// rethrow it
//			throw exc;
//			// hey this exception is happen when we leaving the program how gonna call the excption 
//		}
//		
//	}
//```

public class AroundHandleExceptionDemoApp {

	private static Logger myLogger = 
			Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());
	public static void main(String[] args) {
		// read spring config java class, No xml
		AnnotationConfigApplicationContext context = 
			new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		TrafficFortuneService theFortuneService = context
				.getBean("trafficFortuneService", TrafficFortuneService.class);

		myLogger.info("\nMain Porgram: AroundDemoApp");
		
		myLogger.info("Calling getFortune");
		
		boolean tripWire = true;
		String data = theFortuneService.getFortune(tripWire);
		// The Main App will never know about the exception, Why because we handled in our around advice
		
		myLogger.info("\nMy fortune is: "+data);
		
		myLogger.info("Finished");
		
		// close the context
		context.close();
	}
}
