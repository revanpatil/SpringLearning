package com.luv2code.aopdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		//read spring java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//Get the bean from Spring container 
		AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
		
		//Get the bean from spring container
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO",MembershipDAO.class);
		
		Account theAccount = new Account();
		
		//call the buisness method
		theAccountDAO.addAccount(theAccount, true);
		theAccountDAO.goToSleep(false);
		
		//call the buisness method
		theMembershipDAO.addSillyMember();
		
		//close the context
		context.close();
 	}
	

}
