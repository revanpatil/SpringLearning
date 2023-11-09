package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {

	//this is where we add all our relative advices for logging
	
	//Let's start with @Before Aspect
	
	@Before("com.luv2code.aopdemo.aspect.luv2codePointcut.DAONotGetterandSetter()")
	public void myDemoAspect() {
		System.out.println("=======> Executing @before on demoLog");
	}
	
	
	
}
