package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

//9. What is Spring AutoWiring?
//
//* For dependency injection, Spring can use auto wiring.
//* Spring will look for a class that matches the property
//	* matches by type: class or interface
//* Spring will inject it automatically ... hence it is autowired
//
//Autowiring Ex:
//
//* Injecting FortuneService into a Coach implementation.
//* Spring will scan @Components (I need to satisfy dependency.)
//* Any one implements FortuneService interface?
//* If so, let's inject them. For Ex: HappyFortuneService
//
//Which is an implementation of the FortuneService interface. And spring will find that implementation and automatically inject it into our class. And that's called autowiring. 
//
//
//Autowiring Injection Types
//
//* Constructor Injection
//* Setter Injection
//* Field Injection
//
//Development Process - Constructor Injection
//
//1. Define the dependency interface and class
//2. Create a constructor in your class for injections
//3. Configure the dependency injection with @Autowired Annotation
//
//1. FortuneService.java
//public interface FortuneService {
//	public String getFortune();
//}
//
//HappyFortuneService.java
//@Component
//public class HappyFortuneService implements FortuneService {
//	public String getFortune() {
//		return "Today is your lucky day!"
//	}
//}
//
//2.  TennisCoach.java
//@Component
//public class TennisCoach implements Coach {
//	
//	private FortuneService fortuneService;
//3.	@Autowired
//	public TennisCoach(FortuneService theFortuneService){
//		fortuneService = theFortuneService;
//	}
//}
//
//In FortuneService we want spring to automatically wire up this components, So instead of doing long hand using XML configs we're making use of this autowired annotation. 
//
//Spring will find a bean that implements FortuneService, Spring will scan components there it find the components this FortuneService interface, which in our case is HappyFortuneService and it'll take that bean, actually inject it or autowired here into this TennisCoach. So that's how they handle the dependency injection using that autowired annotation. 
//
//What if there are multiple Implementations?
//
//Spring has special support to handle this case. Use the @Qualifier annotation. 

@Component
public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is your lucky day!";
	}
	// Constructor Injection - Autowired Optional?
	// As pf Spring Framework 4.3 an @Autowired annotation on such a constructor is no longer necessary if the target bean only define one constructor to begin with. However, if several constructors are available, at least one must be annotated to teach the container which one to use.
}
