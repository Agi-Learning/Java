package com.luv2code.springdemo;
//1. Inversion of Control(IoC)
//So Inversion of control is the buzzword that you always hear when you hear of the Spring Framework, So what exactly is Inversion of Control 
//So What exactly in Inversion of control Well, It's simply the design process of externalizing the construction and management of your objects.
//OutSource ->  an object factory
// Check Tab IOC
//In nutshell: The approach of outsourcing the construction and management of Objects.
//with a very rough prototype and we'll try and refine it and refactor it over time, just so you can kind of see the real motivation for inversion of control. And, why we need, in spring framework 
public class MyApp {

	public static void main(String[] args) {
		// TODO create the object
		//BaseballCoach theCoach = new BaseballCoach();
		// 4. Refactoring code: Changing variable reference to use Interface
		// this point theCoach is generic interface. that has a method called getDailyWorkout.
		// Can work with ANY coach implementation!
//		Coach theCoach = new BaseballCoach();
		// For new requirement baseball coach to new track coach.
		Coach theCoach = new TrackCoach();
		// So this point of the object created, one requirements this app should work with any type of coach. so we want to do this SE best practice, and that's to code to an interface. So instead of directly to the BaseballCoach implementation, we wanna make use of a well-defined interface that all coaches will support
		// 2. Refactoring code: Creating an Interface
				
		// use the object
		System.out.println(theCoach.getDailyWorkout());
		// So we almost here this is kind of rough prototype, It's not 100% yet and the reason its not 100%, Coach implementation should be configurable. And right now it's not really configurable. read implementation from a config file and then easly swap by only changing a config file instead of having to change the src code.
	}

}
