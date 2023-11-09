package com.code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class beanScopeDemoApp {

	public static void main(String[] args) {
		
		//Load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		//Retrieve the bean
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		//Check if above two are same beans
		boolean result = (theCoach == alphaCoach);
		
		//Print out the results
		System.out.println("\nPointing to the same object: " + result);
		
		System.out.println("\n Memory location for bean theCoach: " + theCoach);
		
		System.out.println("\n Memory location for bean alphaCoach: " + alphaCoach);
		
		//Close the context
		context.close();
	}

}
