package com.luv2code.aopdemo;

import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		// read spring config java class, No xml
		AnnotationConfigApplicationContext context = 
			new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		AccountDAO theDAO = context
				.getBean("accountDAO", AccountDAO.class);

		// get membership bean from spring container
		MembershipDAO theMembershipDAO = context
				.getBean("membershipDAO", MembershipDAO.class);
				
		// call the bussiness method
		Account myAccount = new Account();
		theDAO.addAccount(myAccount, true);
		theDAO.doWork();
		
		// call the accountdao getter/setter method
		theDAO.setName("foobar");
		theDAO.setServiceCode("silver");
		
		String name = theDAO.getName();
		String code = theDAO.getServiceCode();
		
		// call the membership business method 
		theMembershipDAO.addSillyMember(); 
		theMembershipDAO.goToSleep();
		
		// close the context
		context.close();
	}
}
