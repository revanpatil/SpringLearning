package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	//this is where we add all our relative advices for logging
	
	//Let's start with @Before Aspect
	
//	@Before("execution(* add*(com.luv2code.aopdemo.Account,..))")
//	public void beforeAddAccountAdvice() {
//		System.out.println("======> Executing @before on addAccount()");
//	}
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	private void forDAO() {
		
	}
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	private void getter() {
		
	}
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	private void setter() {
		
	}
	
	@Pointcut("forDAO() && !(setter() || getter())")
	private void DAONotGetterandSetter() {}
	
	@Before("DAONotGetterandSetter()")
	public void beforeAddAccountAdviceNew() {
		System.out.println("======> Executing @before on addAccount()");
	}
	
	@Before("DAONotGetterandSetter()")
	public void performAPIAnalytics() {
		System.out.println("=======> Executing @before on performApiAnalytics");
	}
	
}
