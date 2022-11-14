package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	
	@Autowired
	private FortuneService fortuneService;
//	12. Inject dependencies by setting field values on your class directly. (even for private fields)
//
//	Development Process - Field Injection
//
//	1. Configure the dependency injection with Autowired Annotation
//		* Applied directly to the field
//		* No need for setter methods
//	By making java technology called Reflection	
	// Which one should i use 
	// Ans: Choose a style, Stay consistent in your project, same functionality
	
	
	// define a default constructor
	public TennisCoach() {
		System.out.println(">> TennisCoach: inside default constructor!");
	}
	/*
	// define a setter method
	@Autowired
	public void setFortuneService(FortuneService theFortuneService) {
		System.out.println(">> TennisCoach: inside setFortuneService!");
		fortuneService = theFortuneService;
       // 10. Development Process - Setter Injection
       //		1. Create setter method(s) in your class for injections
       //		2. Configure the dependency injection with @Autowired Annotation
	}
	
	@Autowired
	public void doSomeCrazyStuff(FortuneService theFortuneService) {
		System.out.println(">> TennisCoach: inside doSomeCrazyStuff!");
		fortuneService = theFortuneService;
		// 11. Inject dependencies by calling ANY method on your class.
	}
	*/
	/*
	@Autowired
	public TennisCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	*/
	
	@Override
	public String getDailyWorkout() {
		
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
