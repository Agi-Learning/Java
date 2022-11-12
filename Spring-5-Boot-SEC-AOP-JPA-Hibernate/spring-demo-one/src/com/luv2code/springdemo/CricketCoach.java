package com.luv2code.springdemo;
//8. Inject literal value into our spring objects,
//
//So currently we have our cricket coach. We,ve learnt how to inject a fortune service to our cricket coach but now we'd like to inject some literal values like some string values. 
//So like to inject the actual email address for the coach and the actual team name for the coach, like the Sunrisers 
//
//Development Process
//
//1. Create setter methods in your class for injections
//2. Configure the injection in Spring config file
//
//1. public class CricketCoach implements Coach {
//	private String eamilAddress;
//	private String team;
//
//	public void setEmailAddress(String emailAddress) ...
//
//	public void setTeam(String team) ... 
//}
//
//2.
//<property name="emailAddress" value="thebestcoach@luv2code.com" />
//<properyt name="team" value="Sunrisers Hyderabad" />
public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	
	// add new fields for emailAddress and team
	private String emailAddress;
	private String team;	
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: inside setter method! setEmailAddress");
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach: inside setter method! setTeam");
		this.team = team;
	}

	// create a no-arg constructor
	public CricketCoach() {
		System.out.println("CricketCoach: inside no-arg constructor!");
	}
	
	// our setter method called by spring when they actually inject the dependency. 
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: inside setter method!");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling for 15 minutes";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
