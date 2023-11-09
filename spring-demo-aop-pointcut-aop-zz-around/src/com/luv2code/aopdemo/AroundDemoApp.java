package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
		
		//read spring java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//Get the bean from Spring container 
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService",TrafficFortuneService.class);
		

		System.out.println("Main Program around Demo App");
		
		System.out.println("Calling getFortune()");
		
		String data = theFortuneService.getFortune();
		
		System.out.println("The Fortune is "+data);
		
		System.out.println("Finished");
		
		//close the context
		context.close();
 	}
	

}
