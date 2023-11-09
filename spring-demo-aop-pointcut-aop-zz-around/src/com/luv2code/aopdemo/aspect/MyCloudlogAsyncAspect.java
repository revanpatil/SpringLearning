package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyCloudlogAsyncAspect {

	@Before("com.luv2code.aopdemo.aspect.luv2codePointcut.DAONotGetterandSetter()")
	public void beforeAddAccountAdviceNew() {
		System.out.println("======> Executing @before on addAccount()");
	}
}
