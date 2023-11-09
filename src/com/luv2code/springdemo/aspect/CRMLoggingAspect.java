package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	//Setup Logger
	private Logger myLogger = Logger.getLogger(getClass().getName());

	//Setup pointcut expression 
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	public void forControllerPackage() {

	}

	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	public void forServicePackage() {

	}

	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	public void forDAOPackage() {

	}

	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
	private void forAppFlow() {}

	//Add @Before Advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		//Display the method we are calling 
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("====> In @Before Method" +theMethod);
		//Display the arguments 

		Object args[] = theJoinPoint.getArgs();
		for(Object tempArg : args) {
			myLogger.info("Arguments :"+tempArg);
		}

	}

	//Add @After Advice
	@AfterReturning(pointcut = "forAppFlow()",returning = "theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		//Display the method we are calling 
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("====> In @Before Method" +theMethod);

		//Diplay the result
		myLogger.info("Display the results" +theResult);
	}

}
