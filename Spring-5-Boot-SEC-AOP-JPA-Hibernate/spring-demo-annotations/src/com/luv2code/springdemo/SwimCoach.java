package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

	private FortuneService fortuneService;
//	18. Spring Conguration Inject value form the props file
//
//	Development Process
//
//	1. Create Properties File
//	2. Load Properties File in Spring config
//	3. Reference values from Properties File 
//
//	1. sport.properties
//	foo.email=myeasycoach@luv2code.com
//	foo.team=Awesome Java Coders
//
//	2. SportConfig.java
//	@configuration
//	@PropertySource("classpath:sport.properties")
//	public class SportConfig {
//		
//	}
//
//	3. Inject ref those values from the properties
//	@Value("${foo.email}")
//	private String email;
//
//	@Value("${foo.team}")
//	private String team;
//
//	actaully do that field level injection, so inject the value using the annotation calls @Value that actually give the name of the property 
	@Value("${foo.email}")
	private String email;

	@Value("${foo.team}")
	private String team;
	
	public SwimCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Swim 1000 meters as a warm up";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}
	
//	Problems with Injecting Values - Value not returning from ${foo.email}
//	Ans: This is an issue with Spring Versions 4.2 and lower need to add the code 
//	@Bean
//	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceHolderConfigurer() {
//		return new PropertySourcePlaceHolderConfigurer();
//	}
//	In spring 4.3 and higher, they removed this requirements
//


}
