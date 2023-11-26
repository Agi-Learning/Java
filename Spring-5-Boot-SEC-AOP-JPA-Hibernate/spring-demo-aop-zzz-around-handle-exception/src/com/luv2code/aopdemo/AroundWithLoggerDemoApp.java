package com.luv2code.aopdemo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;
//
//### Resolving Print Order Issue
//
//#### Root Cause
//	* The data is printing to 2 different output streams
//	* Spring is printing to the logger output stream
//	* System.out.println is printing to the standard out output stream
//#### Solution
//	* To have everything in order, you should send to same output stream ( Then everything will synchronize)
//	* We'll change our code to use the logger output stream ... same as Spring

public class AroundWithLoggerDemoApp {

	private static Logger myLogger = 
			Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
	public static void main(String[] args) {
		// read spring config java class, No xml
		AnnotationConfigApplicationContext context = 
			new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		TrafficFortuneService theFortuneService = context
				.getBean("trafficFortuneService", TrafficFortuneService.class);

		myLogger.info("\nMain Porgram: AroundDemoApp");
		
		myLogger.info("Calling getFortune");
		
		String data = theFortuneService.getFortune();
		
		myLogger.info("\nMy fortune is: "+data);
		
		myLogger.info("Finished");
		
		// close the context
		context.close();
	}
}
