package com.luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;
import com.luv2code.aopdemo.AroundWithLoggerDemo;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	Logger mylogger= Logger.getLogger(getClass().getName());
	
	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundFortuneAspect(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
		
		//Prinout which method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		mylogger.info("\n==========>>> Executing @around method" +method);
		
		//Get the begining timeStamp
		long begin = System.currentTimeMillis();
		
		//Execute the method
		Object result = theProceedingJoinPoint.proceed();
		
		//Get the end timeStamp
		long end = System.currentTimeMillis();
		
		//Compute duration and display it
		long duration = end-begin;
		mylogger.info("\n =====> "+duration/1000 + " secconds");
		
		
		//Calculate the differences 
		return result;
		
	}
	
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		String method = theJoinPoint.getSignature().toShortString();
		mylogger.info("\n==========>>> Executing after Finally returning on method" +method);
	}
	
	
	@AfterReturning(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAdvice(JoinPoint theJoinPoint, List<Account> result) {
		//Print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		mylogger.info("\n==========>>> Executing after returning on method" +method);
		
		//print out the result
		mylogger.info("\n =======>>" + result);
		
		
		//let's post process the data ----> Let's modify it 
		
		//Convert the result to upperCase:
		convertTheResultToUpperCase(result);
		
		//print out the result
		mylogger.info("\n =======>>" + result);
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
		mylogger.info("=======> Executing @before on demoLog");
	}
	
	@AfterThrowing(
			pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing = "e")
	public void afterThrowingFindAccountAdvice(JoinPoint theJointPoint , Throwable e) {
		//Print out which method we are advising on
				String method = theJointPoint.getSignature().toShortString();
				mylogger.info("\n==========>>> Executing after throwing on method" +method);
				
				//print out the result
				mylogger.info("\n =======>>" + e);
				
	}
	
}
