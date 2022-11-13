package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//Bean Scopes
//* Scope refers to the lifcycle of a bean
//* How long does the bean live?
//* How many instances are created?
//* How is the bean shared?
//
//Default Scope: Singleton
//<beans ...>
//	<bean id="myCoach"
//		class="com.luv2code.springdemo.TrackCoach">
//	</bean>
//</beans>
//
//What is a singleton?
//* Spring Container creates only one instance of the bean, by default
//* It is cached in memory
//* All requests for the bean
//* will return a SHARED reference to the SAME bean
//
//Coach theCoach = context.getBean("myCoach", Coach.class);
//
//Coach alphaCoach = context.getBean("myCoach", Coach.class);
//
//-----> TrachCoach
//
//And 2 object ref here and pointing to the same area of the memory or they point to the same bean. Spring makes use of a singleton It'll create only one bean and then share it for everyone who req that bean
//
//the best use case for this is for a stateless bean, while you don't need to maintain any state
//
//Additional Spring Bean Scopes
//singleton -> Create a single shared instance of the bean. Default scope.
//prototype -> Creates a new bean instance for each container request. 2 TrackCoach
//request -> Scoped to an HTTP web request. Only used for web apps.
//session -> Scoped to an HTTP web session. Only used for web apps.
//global-session -> Scoped to a global HTTP web session. Only used for web apps.

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		// load spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("file:src/beanScope-applicationContext.xml");
		
		// retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("myCoach", Coach.class);

		// Check if they are the same
		boolean result = (theCoach == alphaCoach);
		
		System.out.println("\nPointing to the same object: "+result);
		System.out.println("\nMemory location for theCoach: "+theCoach);
		System.out.println("\nMemory location for alphaCoach: "+alphaCoach+"\n");
		
		context.close();
	}

}
