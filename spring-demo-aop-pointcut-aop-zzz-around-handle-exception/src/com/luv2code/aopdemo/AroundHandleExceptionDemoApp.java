package com.luv2code.aopdemo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {

	public static void main(String[] args) {
		
		Logger mylogger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());
		
		
		//read spring java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//Get the bean from Spring container 
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService",TrafficFortuneService.class);
		

		mylogger.info("Main Program around Demo App");
		
		mylogger.info("Calling getFortune()");
		
		boolean tripWire = true;
		String data = theFortuneService.getFortune(tripWire);
		
		mylogger.info("The Fortune is "+data);
		
		mylogger.info("Finished");
		
		//close the context
		context.close();
 	}
	

}
