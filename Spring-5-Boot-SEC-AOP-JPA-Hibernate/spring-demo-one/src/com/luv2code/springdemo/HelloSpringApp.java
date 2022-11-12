package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;
//5. Ideal Solution -> Spring IOC
//check Tab IS
//Spring provoids the object factory, So we can have our application talk to spring, say, "Hey, give me an object based on an configuration file or annotation," Spring will give you the appropriate implementation. So then your app is configurable and will have full support for that based on our application requirements.
//
//Spring Container
//	1. Create and manage objects (Inversion of Control)
//	2. Inject object's dependencies (Dependency Injection)
//
//Configuring Spring Container
//	1. XML configuration file (legacy, but most legacy apps still use this)
//	2. Java Annotations (modern)
//	3. Java Source Code (modern)
//
//Spring Development Process
//	1. Configure your Spring Beans
//	2. Create a Spring Container
//	3. Retrieve Beans from Spring Container
//
//1. Configure your Spring Beans File: applicationContext.xml
//<beans>
//	<bean id="myCoach"
//		class="com.luv2code.springdemo.BaseballCoach">
//	</bean>
//</beans>
//simply the id the java application will use when they wanna retrieve a bean from the Spring Container. And again class is the actual class or implementation that you'll have for your application. 
//
//2. Create a Spring Container
//* Spring container is generically known as ApplicationContext
//* Specialized implementations
//	* ClassPathXmlApplicationContext
//	* AnnotationConfigApplicationContext
//	* GenericWebApplicationContext
//	* others ...
//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//And I construct this object and I pass in the actual name of the configuration file that I'm using for Spring. 
//
//3. Retrieve Beans from Container
//Hey give me coach object, based on information in the configuration file, It'll give your an implementation of that given interface. 
//
//Coach theCoach = context.getBean("myCoach", Coach.class);
//myCoach relates to the actual bean ID to find in the configuration file.Y
//
//Coach.class thats the name of the actual -> interface that baseball coach -> implements. 
//
//FAQ: What is a Spring Bean?
//A "Spring Bean" is simply a Java object.
//When Java objects are created by the Spring Container, then Spring refers to them as "Spring Beans".
//
//Spring Beans are created from normal Java classes, just like Java objects.
//
//
//application has the lots of namespaces, xml spring process the file 
//Step 1: Configure your Spring Beans
//xml schema, has 2 attribute I need to set is 'id equals' 
public class HelloSpringApp {

	public static void main(String[] args) {
		// TODO
		// load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("file:src/applicationContext.xml");
		// retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		// But these bean actually has dependencies, actually a fortune servic, So it actually injects that fortune service on the bean
		// we actually get the bean fully assemble remember Spring factory create all the appropriate beans and dependencies and inject those dpendencies so you can make use of them so you'll get a object so your car has already been built

		// call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// let's call our new method for fortunes
		System.out.println(theCoach.getDailyFortune());
		
		// close the context
		context.close();
		
		// Now our app is configurable And also we can easily change the coach for another sport by simply putting in a different coach implementation 
		// Why do we specify the Coach interface in getBean()>
		// Coach theCoach = context.getBean("myCoach", Coach.class);
		// When we pass the interface to the method, behind the scenes Spring will cast the object for you
	}
}
