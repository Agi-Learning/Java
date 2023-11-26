package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


//## Aspect-Oriented Programming (AOP): AOP and Spring MVC
//
//### Goal
//* Add AOP Logging support to our Spring MVC app (CRM Web App).
//
//Check Tab ->
//
//### Development Process
//
//1. Add AspectJ JAR file to web project
//2. Enable AspectJ Auto Proxy
//3. Create Aspect 
//	1. Add logging support
//	2. Setup pointcut declarations
//	3. Add @Before advice 
//	4. Add @AfterReturning advice
//
//
//#### Step 1: Add AspectJ JAR file to web project
//
//* All Spring projects require AspectJ JAR file for AOP support
//* can download from
//	* http://www.luv2code.com/download-aspectjweaver
//* Add JAR file to your web project: WEB-INF/lib directory
//
//#### Step 2: Enable AspectJ Auto Proxy (XML)
//
//```xml
//	<beans xmlns="http://www.springframework.org/schema/beans"
//		...
//		xmlns:aop="http://www.springframework.org/schema/aop"
//		xsi:schemaLocation="
//		...
//			http://www.springframework.org/schema/aop
//			http://www.springframework.org/schema/aop/sprint-aop.xsd">
//
//		<!-- Add AspectJ autoproxy support for AOP -->
//		<aop:aspectj-autoproxy />
//	</beans>
//```
//
// * If you want to use pure Java configuration then use the annotation
// @EnableAspectJAutoProxy
// * For processing @Aspect classes

@Aspect
@Component
public class CRMLoggingAspect {
	
	// setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	
	// setup pointcut declarations
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	// do the same for service and dao
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	private void forServicePackage() {}

	// setup pointcut declarations
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	// add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		// display method we are calling
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("======>> in @Before: calling method: " + theMethod);
		
		
		// display the arguments to the method
		Object[] args = theJoinPoint.getArgs();
		
		// loop thru and display args
		for(Object tempArg: args) {
			myLogger.info("======>> argument: "+tempArg);
		}
	}

	// add @AfterReturning advice
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="theResult"
			)
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		// display method we are returning from
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("======>> in @After: from method: " + theMethod);
		
		// display data returned
		myLogger.info("======>> result: "+theResult);
	}
}
