package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//14. @Scope Annotation
//Explicitly Specify Bean Scope
//@Scope("Singleton")
//@Scope("prototype") It's gonna create a new object for each request. and I give the actual scope in parens or quotes here. 
public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		// load spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("file:src/applicationContext.xml");
		
		// retrieve bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
	
		// check if they are the same object
		boolean result = (theCoach ==  alphaCoach);
		
		System.out.println("\nPointing to the same object: "+result);
		
		System.out.println("\nMemory location for theCoach: "+theCoach);
		
		System.out.println("\nMemory location for alphaCoach: "+alphaCoach);
		
		// close the context
		context.close();
	}

}
