package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component
//@Scope("prototype")

@Component
public class TennisCoach implements Coach {
	
//	13. Qualifiers for DI
//	What happens multiple injection out there 
//	Muliple fortuneService Implementation
//
//	FortuneService
//
//	1. HappyFortuneService
//	2. RandomFortuneService
//	3. DatabaseFortuneService
//	4. RESTFortuneService
//
//	Which one i pick? problem - Injection of autowired dependencies failed, No qualifying bean of type
//
//	here its annotation called Qualifier, bean id actually bean i want to use spring to inject. it will resolve the problem of too many implementations. 
//	I am going to use default name happyFortuneService
//	@Qualifier('happyFortuneService')
//
//	Injection Types
//
//	* can apply @Qualilifier annotation to
//		1. Constructor injection
//		2. Setter injection methods
//		3. Field injection
//	@Qualifier("happyFortuneService")
	

	@Autowired
	@Qualifier("randomFortuneService")
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
//	15. Bean Lifecycle Methods - Annotations
//
//	1. Define your methods for init and destroy
//	2. Add annotations: @PostConstruct and @PreDestroy
//
//	For initialization give it any method name, and you simply annotate it with @PostConstruct. So as the annotation says, this code will execute after has been constructed, and after injection of dependencies So this is where you can place your own custom initialization work. 
//
//	Destroy: method config
//	@PreDestroy
//	So before your bean destroy you can annotate a method with @PreDestroy, and you can write own custom cleanup code to exe. 
//
//	If you are using Java 9 or higher, then you will encounter an error when using @PostConstruct and @PreDestroy in your code.

	// define my init method
	
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println(">> TennisCoach: inside of doMyStartupStuff");
	}
	
	
	// define my destroy method
	
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println(">> TennisCoach: inside of doMyCleanStuff()");
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

//	Annotations - Default Bean Names - The Special Case
//	If the annotations value doesn't indicate a bean name, an appropriate name will be built based on the short name of the class
//	For the case of RESTFortuneService
//
//	RESTFortuneService --> RESTFortuneService
//
//	No conversion since the first 2 charactes are upper case.
//
//	Behind the scenes, Spring uses the Java Beans Introspector to generate the default bean name. 
//	@Component("foo")
//	public class RESTFortuneService
//
//	Using @Qualifier with constructors
//
//	@Qualifer is a nice feature, but it is tricky when used with Constructors
//	The syntax is much diff from other examples and not exactly intuitive. Consider this the "deep end of the pool" when it comes to Spring config.
//
//	You have to place the @Qualifier annotation inside of the constructor arguments.
//
//	@Qulifier with Setter Injection
//	@Autowired
//	public TennisCoach(@Qualifier("randomFortuneService") FortuneService theFortuneService)
//
//	How to inject prop file using Java annotations
//	Ans: This solution show you how inject values from a prop file using annotations. The values will no longer be hard coded in the java code
//	location="classpath:sport.properties"
//
//	Inject the props values into your Swim Coach:
//
//	@Value("${foo.email}")
//	private String email;
//
//	@Value("${foo.team}")
//	private String team;
//
//	Dependency Injection with Annotations
//
//	1. Define a new implementation for the FortuneService.
//		* Your fortune service should read the fortunes from a file
//		* The fortune service should load the fortunes intot an array
//		* When the getFortune() method is called it would return a random fortune from the array.
//	2. Inject your new dependecy into your Coach implementation
//	3. Test your app to verify you are getting random fortunes based on your fortune file.
}
