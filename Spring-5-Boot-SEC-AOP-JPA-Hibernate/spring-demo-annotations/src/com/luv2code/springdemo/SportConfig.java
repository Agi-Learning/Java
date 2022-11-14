package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//16. Spring Configuration with java code (no xml)
//
//* Instead of config Spring container using XML
//* Configure the Spring container with java code (pure java Config )
//
//3 Ways of config Spring container
//
//1. Full XML Config
//2. XML Component Scan
//3. Java Config Class
//
//Developement process
//1. Create a Java class and annotate as @Configuration
//2. Add component scanning support: @ComponentScan(optional)
//3. Read Spring java config class
//4. Retrieve bean from Spring container
//
//create a java class annotate the java config, adding some beans configuration
//@Configuration
//@ComponentScan("com.luv2code.springdemo")
//public class SportConfig {
//	
//}
//
//AnnotationConfigApplicationContext context = 
//	new AnnotationConfigApplicationContext(SportConfig.class);
//
//Coach theCoach = context.getBean("tennisCoach", Coach.class);



// actually this is java config, all of the rules direction with the config file
@Configuration
//@ComponentScan("Com.luv2code.springdemo")
public class SportConfig {
	
	// define bean for our sad fortune service
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	// define bean for our swim coach AND inject dependency
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
}
