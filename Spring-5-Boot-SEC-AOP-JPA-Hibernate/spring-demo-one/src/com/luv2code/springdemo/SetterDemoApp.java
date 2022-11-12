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
		// call our new methods to get the literal values
		
		System.out.println(theCoach.getEmailAddress());
		
		System.out.println(theCoach.getTeam());
		
		
		// close the context
		context.close();
		
		// Why do we use CricketCoach class instead of Coach interface?
		// The getTeam() method is only defined in the CricketCoach class. Its not part of the Coach interface.
		
		// The Coach interface has two methods: getDailyWorkout and getDailyFortune
		// The CricketCoach class has four methods: getDailyWorkout, getDailyFortune, getTeam and setTeam
		
		// When you retrieve a bean from the Spring container using the Coach interface:
		// You only have access to the methods defined in the Coach interface: 2 Even though the actual implementation has additional methods, you only have visibility to methods that are defined at the Coach interface level.
		
		// When you retrieve a bean from the Spring container using the CricketCoach class:
		// You have access to the methods defined in the Coach interface: 2
		// Also you have access to the additional methods defined in the CricketCoach 4
		// The bottom line is it depends on how you retrieve the object and assign it ... that determine the visibility you have to the methods.
//		8. Inject Literal Values
//		CricketCoach  ---------> FortuneService
//
//		So we could inject the email address and the team. they only problem is that those values hardcoded in the config file. 
//		And what we'd like to do is be able to read this information from a props file So we'll have an external props file we'll have our values there and team name from this properties file. 
//
//		Developement Process
//		1. Create Properties File
//		2. Load properties file in Spring config file
//		3. Referece values from Properties File
//
//		1. sport.properties
//		foo.email=myeasycoach@luv2code.com
//		foo.team=Royal Challengers Banglore
//		the actual property name you can give any name that you want. There's no direct relation to your actual bean. You can call them foobar, test, funny, bozo, anything. The only thing is that you have to simply be consistent between refering to the property name in this config file and also referring to the prop name in your spring setup.
//
//		2. <context.property-placeholder location="classpath:sport.properties" />
//		loading the props file in the spring config, So in your application.xml you simply use of this context propery placeholder, you give the location for so in this case, the file will be on our class path, and you give the actual filename
//
//		so this ex our props file sport.properties And so it'll actually load that props file into memory and then you can use it within this spring config file. 
//
//		3. <property name="emailAddress" value="${foo.eamil}" /> 
//		   <property name="team" value="${foo.team}" /> 
//
		// Dependency Injection with XML Config
		// 1. Define a new implementation for the FortuneService.
		// 		a. When the getFortune() method is called it should return a random fortune from the array
		// 		b. Your fortune service should define three fortunes in an array
		// 2. Inject your new dependency into your Coach implementation.
		// 3. Test your application to verify you are retrieving random fortunes.
	}
}
