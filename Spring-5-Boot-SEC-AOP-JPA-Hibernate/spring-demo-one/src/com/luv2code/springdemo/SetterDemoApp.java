package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//7. Setter Injection
//Spring Framework Inject dependencies by calling setter methods on your class 
//
//Development Process - Setter Injection
//1. Create setter methods in your class for injections.
//2. Configure the dependency injection in Spring config file.
//
//1. CricketCoach.java
//public class CricketCoach implements Coach {
//	private FortuneService fortuneService;
//
//	public CricketCoach() {}
//
//	public void setFortuneService(FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//	}
//	then we have setter method for setFortuneService. This is the method that will be called by Spring when they inject the dependency using setter injection. 
//}
//
//2. <propery name="fortuneService" ref="myFortuneService" />
//
//public void setFortuneService(...)
//It'll take that property name and call the setter method on your class for that given propery. don't look the public method call setFortuneService, So Spring will actually call the setFortune Service and they'll pass in that value for that call. 
//so in general, any property name you have, Spring will attempt to make a call to the setter method for that given property. 
public class SetterDemoApp {

	public static void main(String[] args) {
		// TODO 
		// load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("file:src/applicationContext.xml");
		// retrieve bean from spring container
		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);
		// call methods on the bean
		// ... let's come back to this ...
		System.out.println(theCoach.getDailyFortune());
		
		System.out.println(theCoach.getDailyWorkout());
		
		// close the context
		context.close();
	}

}
