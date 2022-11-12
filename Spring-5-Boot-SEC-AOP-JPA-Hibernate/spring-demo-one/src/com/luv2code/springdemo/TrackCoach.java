package com.luv2code.springdemo;

public class TrackCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		// new trackCoach implements coach and we gave our custom implementation here for get daily workout.
		return "Run a hard 5K";
	}

}
