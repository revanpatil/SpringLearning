package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class luv2codePointcut {
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void forDAO() {
		
	}
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	public void getter() {
		
	}
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	public void setter() {
		
	}
	
	@Pointcut("forDAO() && !(setter() || getter())")
	public void DAONotGetterandSetter() {}
}
