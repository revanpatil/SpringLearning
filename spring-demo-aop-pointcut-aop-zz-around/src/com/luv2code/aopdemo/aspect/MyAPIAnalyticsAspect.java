package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(1)
public class MyAPIAnalyticsAspect {

	@Before("com.luv2code.aopdemo.aspect.luv2codePointcut.DAONotGetterandSetter()")
	public void performAPIAnalytics(JoinPoint theJoinPoint) {
		System.out.println("=======> Executing @before on performApiAnalytics");
		
		// Display Method Signature 
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Method Signature" +methodSig);
		
		//Display Method Signature Arguments
		Object[] methodPara = theJoinPoint.getArgs();
		
		for(Object tempArgs : methodPara) {
			System.out.println(tempArgs);
			
			if(tempArgs instanceof Account) {
				Account temAccount = (Account) tempArgs;
				System.out.println("Name" + temAccount.getName());
				System.out.println("Level" +temAccount.getLevel());
			}
		}
		
	}
}
