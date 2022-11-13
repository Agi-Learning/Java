package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;
//Spring Configuration with Annotations
//
//What are Java Annotations?
//* Special labels/markers added to Java classes
//* Provide meta-data about the class (size of shoe, label)
//* Processed at compile time or run-time for special processing
//
//Example
//public class TrackCoach implements Coach {
//	@Override
//	public String getDailyWorkout() {
//		return "Run a hard 5K";
//	}
//}
//this annotation does it tells to the compiler, "hey we're gonna implement a given interface or extend a class and we're gonna override the method."
//
//Why Spring Configuration with Annotations?
//
//* XML configuration can be verbose
//* Configure your Spring beans with Annotations
//* Annotations minimizes the XML configuration
//
//Imagine a scenario where you had a spring project and you had 30 beans or maybe a hundred beans, you'd have to list each one of those in your XML config file and that would just take a lot of time and be very verbose or a lot of work.
//
//Annotation allow you to minimize the XML configuration. Again, annotation are like meta-data for your class. 
//
//Scanning for Component Classes
//
//* Spring will scan your java classes for special annotations.
//* Automatically register the beans in the Spring container.
//
//Development Process
//
//1. Enable component scanning in Spring config file
//2. Add the @Component Annotation to your Java classes
//3. Retrieve bean from Spring container
//
//1. base-package="com.luv2code.springdemo" We'll simply say context component scan and you give the base package that you want it to scan, 
//and so spring will actually go through and scan all classes in this package and all sub packages and it'll identify the components that have that annotation on it and it'll automatically register them with the Spring container that happens in the background for you automatically
//
//2. @Component("thatSillyCoach")
//Hey when you scan, this class is a special Spring bean, i like for it register it So here we make use of the @Component Annotation 
//
//and here this is for our tennis coach and we simply give the actual bean ID that we wanted to use. So @Component thatSillyCoach, it'll actually register this tennis coach as a Spring bean and it'll have the bean ID of thatSilly Coach. And again, the bean ID can be anything. 
//
//3. same as before
public class AnnotationDemoApp {

	public static void main(String[] args) {
		
		// read spring Config file
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("file:src/applicationContext.xml");
		
		// get the bean from spring container
		Coach theCoach = context.getBean("thatSillyCoach", Coach.class);
		
		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// close the context
		context.close();
	}

}
