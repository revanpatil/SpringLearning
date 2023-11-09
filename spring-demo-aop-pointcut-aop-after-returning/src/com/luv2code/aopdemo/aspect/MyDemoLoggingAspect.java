package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {

	
	@AfterReturning(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAdvice(JoinPoint theJoinPoint, List<Account> result) {
		//Print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n==========>>> Executing after returning on method" +method);
		
		//print out the result
		System.out.println("\n =======>>" + result);
		
		
		//let's post process the data ----> Let's modify it 
		
		//Convert the result to upperCase:
		convertTheResultToUpperCase(result);
		
		//print out the result
		System.out.println("\n =======>>" + result);
	}
	
	
	//this is where we add all our relative advices for logging
	
	//Let's start with @Before Aspect
	
	private void convertTheResultToUpperCase(List<Account> result) {
		
		for(Account account : result) {
			
			//get uppercase version of name 
			String name = account.getName().toUpperCase();
			
			//update the name 		
			account.setName(name);
		}
		
	}


	@Before("com.luv2code.aopdemo.aspect.luv2codePointcut.DAONotGetterandSetter()")
	public void myDemoAspect() {
		System.out.println("=======> Executing @before on demoLog");
	}
	
	
	
}
