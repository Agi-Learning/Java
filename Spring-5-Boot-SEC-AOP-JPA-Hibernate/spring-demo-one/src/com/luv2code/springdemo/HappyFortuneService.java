package com.luv2code.springdemo;
//6. Dependency Injection
//The dependency inversion principle 
//The client delegates to calls to another object the responsibility of providing its dependencies.
//check Tab Car Example
//and put in a request and they'll build the car for you, So, at the factory, you have all the different parts for the car. You have like that car chassis, you have the engine, the tires, the seats, the electronics, they exhaust, and so on. And the mechanics or the assemblers there, the technicians, theyll actually assemble the car for you and then deliver to you the final car. So, you don't have to actually build the car, 
//
//the car is already built for you at the factory. So, they actually inject all of the dependencies for the car. So, they inject the engine, tires, the seats, and so on. basically what we have the dependency injections, So you simply outsource the constuction and injection of your object to an external entity. In this case Car Factory
//
//So, then when you retrieve an object like a coach object, this coach object may have some additional dependencies. So these dependencies are really just helper objs, other objs that it needs to perform its operation.
//
//So instead of you having to manually build a coach object and all of its dependencies, the Spring framwork or the Spring factory will actually do  this work for you
//
//Demo Example
//* Our Coach already provides daily workouts
//
//* Now will also provide daily fortunes
//	1. New helper: FortuneService
//	2. This is a dependency
//
//* All right, so we'll walk through this with an example again. So our coach already provides daily workouts. 
//
//Coach ---------> FortuneService
//
//Now, our coach will also provide daily fortunes like your good luck fortune. 
//This coach will actually make use of a helper called FortuneService,And this will call a dependencies, Because a coach depends on the FortuneService in order to serve up the daily fortunes. 
//
//Injection Types
//* There are many types of injection with Spring
//
//* We will cover the two most common
//	1. Constructor Injection
//	2. Setter Injection
//
//* Will talk about "auto-wiring" in the Annotations section later
//
//Development Process - Constructor Injection
//
//1. Define the dependency interface and class
//2. Create a consturctor in your class for injections
//3. Configure the dependency injection in Spring config file
//
//1. FortuneService.java
//public interface FortuneService {
//	public String getFortune();
//}
//
//HappyFortuneService.java
//public class HappyFortuneService implements FortuneService {
//	public String getFortune() {
//		return "Today is your lucky day!"
//	}
//}
//an implementation maybe an implementation that could read something from the file system or maybe from a database or possibily a web service, But we'll keep it simple for now, talk about advanced features a little later.
//
//2. BaseballCoach.java
//public class BaseballCoach implements Coach {
//	private FortuneService fortuneService;
//
//	public BaseballCoach(FortuneService theFortuneService){
//		fortuneService = theFortuneService;
//	}
//}
//
//3. applicationContext.xml
//<bean id="myFortuneService"
//	Define dependency/helper
//	class="com.luv2code.springdemo.HappyFortuneService">
//</bean>
//<bean id="myCoach"
//	class="com.luv2code.springdemo.BaseballCoach">
//	<constuctor-arg ref="myFortuneService" />
//	now Inject the dependency/helper using "constuctor injector"
//</bean>
//i have bean it=myCoach class baseball coach. Now i do is i tell Spring "hey inject a dependency into the baseball coach." so i have consturctor-arg and I have ref="myFortuneService". That's the same id name of the bean up top 
//behind the scenes is that when Spring makes it to this line of code in your config file, they'll actually look at your baseball coach, they'll call your baseball coach's constuctor, and they'll pass in a ref to the my fortune service. 
//
//So, Spring will actually constuct your object and passing the appropriate data into the constructor. And that happens behind the scenes because rememeber Spring has an object factory. Spring is responsible for creating objects and also its responsible for injecting their dependencies.
public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return "Today is your lucky day!";
	}
	// What is the purpose for the no arg constructor?
	// When you don't define any consturctor in you class , compiler defines default one for you, however when you declare any constructor, compiler doesn't do it for you.
	// Since your have defined a constructor in class code, compiler didn't create default one. While creating obj you are invoking default one, which doesn't exist in class code. Then the code gives an compilation error.
}







