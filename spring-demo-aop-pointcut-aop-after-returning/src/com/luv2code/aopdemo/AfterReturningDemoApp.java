package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		
		//read spring java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//Get the bean from Spring container 
		AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
		
		//Call method to find Accounts
		List<Account> theAccounts = theAccountDAO.findAccounts();
		
		//Display the Accounts 
		System.out.println("\n\nAfter returning Main App");
		System.out.println("----");
		System.out.println(theAccounts);
		System.out.println("\n");
		
		
		//close the context
		context.close();
 	}
	

}
