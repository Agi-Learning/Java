package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsynAspect {
	
	// add a new advice for @AfterReturning on the findAccounts method
	
	@AfterReturning(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(
			JoinPoint theJoinPoint, List<Account> result){
		// Print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n======>>> Executing @AfterReturning on method: "+method);
		// Print out the results of the method call
		System.out.println("\n===>>> result is: "+result);
	}
	
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void logToCloudAsync(){
		System.out.println("\n ===> Logging to Cloud in async fashion");
	}
	
}
