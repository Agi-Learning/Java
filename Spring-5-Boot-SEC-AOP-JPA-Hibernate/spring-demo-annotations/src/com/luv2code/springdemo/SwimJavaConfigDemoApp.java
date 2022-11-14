package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//17. Defining Spring Beans
//let's take new class introduce a our new Coach called Swim Coach. He's gonna implement the coach interface and it's a plain old java class with no special annotations. 
//
//So they have coach that'll also have a fortune service implementation, and we'll learn how to inject that fortune service using raw java code
//
//public class SwimCoach implements Coach {
//	...
//}
//
//Development Process
//
//1. Define method to expose bean
//2. Inject bean dependencies
//3. Read Spring Java config class
//4. Retrieve bean from spring container
//
//1. We're gonna make use of a new annotation called @Bean. So this is basically defines a bean, here will provoid method called swim coach 
//
//@Bean
//public Coach swimCoach() {
//	SwimCoach mySwimCoach = new SwimCoach();
//	return mySwimCoach;
//}
//
//create instance of SwimCoach and return it. the method name here swimCoach that is actual bean id registered by the SC 
//not using component scan In this configuration we're actually gonna define each bean individually within the configuration class.
//what about our dependencies?
//Coach ------------> FortuneService
//
//2. 
//HappyFortuneService() craete instance of HappyFortuneService and return it
//now bean method name(happyFortuneService) will be the bean id the spring will use when they register this bean with the application context 
//then we will use the later on new swimcoach(happyFortuneService()) will pass in HappyFortuneService. We're actually calling that bean ref up top and Spring will intercept that and handle it accordingly based on the bean configuration.   
//
//@Bean 
//public FortuneService happyFortuneService(){
//	return new HappyFortuneService();
//}
//@Bean
//public Coach swimCoach() {
//	SwimCoach mySwimCoach = new SwimCoach(happyFortuneService())
//	return mySwimCoach;
//}
//
//3.4. same like before 

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
		// read spring Config file
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		// 2. get the bean from spring container

//		Coach theCoach = context.getBean("swimCoach", Coach.class);
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
		
		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// close the context
		System.out.println(theCoach.getDailyFortune());
		// call our new swim coach methods ... has the props values injected
		System.out.println("email: "+theCoach.getEmail());		
		System.out.println("email: "+theCoach.getTeam());
		
		// close the context
		context.close();
	}

}
//How @Bean works behind the scenes
//
//Q: During All Java Config, how does the @Bean annotation work in the background?
//
//Ans: 
//@Bean
//public Coach swimCoach() {
//	SwimCoach mySwimCoach = new SwimCoach();
//	return mySwimCoach;
//}
//At a high-level, spring creates a bean component manually, By default the scope is singleton. So any req for a "swimCoach" bean, will get the same instance of the bean since singleton is the default scope.
//
//However, let's break it down 
//@Bean
//Then @Bean annotation tells Spring that we are creating a bean component manually. We didn't specify a scope so the default scope is singleton
//public Coach swimCoach(){}
//This specifies that the bean will bean id of "SwimCoach". The method name determines the bean id. The return type is the Coach interface. This is useful for dependency injection. This can help Spring find any dependencies that implement the Coach interface.
//public Coach swimCoach(){}
//The @Bean annotation will intercept any reqs for "swimCoach" bean. Since we didn't specify a scope, the bean scope is singleton. As a result, it will give the same instance of the bean for any reqs.
//
//SwimCoah mySwimCoach = new SwimCoach();
//This code will create a new instance of the SwimCoach;
//
//return mySwimCoach;
//this code return an instance of the swimCoach
//
//Now let's step back and look at the method in it's entirety.
//
//It is important to note that this method has the @Bean annotation. The annotation will intercept ALL calls to the method "swimCoach()". since no scope is specified the @Bean annotation uses singleton scope. Behind the scences, during the @Bean interception, it will check in memory of the Spring container and see if the given bean has already been created. 
//
//If this is the first time the bean has been created then it will exe the method as normal. It will also register the bean in the application context. So that is knowns that the bean has already been created before. Effectively setting a flag.
//
//The next time this method is called, the @Bean annotation will check in memory of the Spring container (applicationContext) and see if this given bean has already been created. Since the bean has already been created then it will immediately return the instance from mem. it will not execute the code inside of the method. Hence this is a singleton bean.
//
//The code for
//SwimCoach mySwimCoach = new SwimCoach();
//return mySwimCoach;
//is not executed for subsequent req to the method public Coach swimCoach(). This code is only exe once during the init bean creation since it is singleton scope.
//
//@Bean
//public FortuneService sadFortuneService() {
//	return new SadFortuneService();
//}
//
//@Bean
//public Coach swimCoach(){
//	SwimCoach mySwimCoach = new SwimCoach(sadFortuneService());
//	return mySwimCoach;
//}
//
//we define a bean for the sad fortune service. Since the bean scope is not specified, it defaults to singleton
//
//Any Calls for sadFortuneService, the @Bean annotation intercepts the call and checks to see if an instance has been created. First time through, no instance is created so the code exe as desired. For subsequent calls, the singleton has been created so @Bean will immediately return with the singleton instance.
//
//Now to the main code based on your q
//return new SwimCoach(sadFortuneService())
//This code creates an instance of SwimCoach. Note the call to the method sadFortuneService(). We are calling the annotated method above. The @Bean will intercept and return a singleton instance of sadFortuneService. The sadFortuneService is then injected into the swim coach instance.
//
//
//

