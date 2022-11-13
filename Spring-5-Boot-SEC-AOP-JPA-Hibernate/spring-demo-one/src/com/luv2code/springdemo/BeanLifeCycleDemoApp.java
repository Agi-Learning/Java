package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//Bean Lifecycle
//Check Tab BL
//
//Container starts,the beans are instantiated, and then actual dependencies are injected, next Internal spring processing that occurs with the bean factory, and then you adding own custom initialization code, and that point bean is ready to use call methods on it do work with the bean, so on and so forth. At a certain point container actually shutdown meaning your application is shut down, you also chance call your custom destroy method that code will execute before the actual application is stopped or before the actual bean's lifecycle is over. 
//
//
//Bean Lifecycle Methods/Hooks
//* You can add custom code during bean intialization
//	1. Calling custom business logic methods
//	2. Setting up handles to resources (db, sockets, file etc)
//
//* You can add custom code during bean destruction
//	1. Calling custom bussiness logic method
//	2. Clean up handles to resources (db, sockets, files etc)
//
//During Bean lifecycle spring allow you to call some of your custom code, and these are what we call hooks, where you can actually hook in code to execute during bean initialization or bean destruction. 
//
//Init: method configuration
//<beans ...>
//	< bean id="myCoach"
//		class="com.luv2code.springdemo.TrackCoach"
//		init-method="doMyStartupStuff">
//	</bean>
//</beans>
//
//Destroy: method configuration
//<beans ...>
//	< bean id="myCoach"
//		class="com.luv2code.springdemo.TrackCoach"
//		init-method="doMyStartupStuff"
//		destroy-method="doMyStartupStuff">
//	</bean>
//</beans>
//
//Developement Process
//
//1. Define your methods for init and destroy
//2. Configure the method names in Spring config file
//
//Defining init and destroy methods Method Signatures
//
//When using XML config, I want to provide additional details regarding the method signatures of the init-method and destroy-method
//
//Access modifier
//The method can have any access modifier (public, protected, private)
//
//Return Type
//The method can have any return type. However, "Void" is most commonly used, If you give a return type just note that you will not be able to capture the return value. As a result "void" is commonly used
//
//Method name
//The method can have any method name.
//
//Arguments
//The method can not accept any args. The method should be no-arg
//
//
//
public class BeanLifeCycleDemoApp {

	public static void main(String[] args) {
		// load spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("file:src/beanLifeCycle-applicationContext.xml");
		
		// retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		System.out.println(theCoach.getDailyWorkout());
		
		context.close();
	}
	// Destroy Lifecycle and Prototype Scope
	// For "prototype" scoped beans, Spring does not call the destroy method. 
	
	// In contrast to the other scopes, Spring does not manage the complete lifecycle of a prototype bean: the container instantiates, configures, and otherwise assembles a prototype object, and hands it to the client, with no further record of that prototype instance.
	
	// Thus, although initialization lifecycle callback methods are called on all objects regardless of scope, in the case of prototypes, configured destruction lifecycle callbacks are not called. The client code must clean up prototype-scoped objects and release expensive resources the prototype beans are holding.


}
