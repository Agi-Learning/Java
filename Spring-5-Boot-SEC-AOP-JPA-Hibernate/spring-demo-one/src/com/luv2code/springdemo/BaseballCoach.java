package com.luv2code.springdemo;

public class BaseballCoach implements Coach {
	
	//	3. Refactoring code: Implementing an Interface
	// That our BaseballCoach is compliant by implementing a given Coach interface. so we can access the BaseballCoach specifically or we can access it in a generic fashion using the Coach interface.
 	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}
}
