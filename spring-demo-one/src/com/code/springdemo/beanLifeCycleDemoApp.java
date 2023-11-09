package com.code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class beanLifeCycleDemoApp {

	public static void main(String[] args) {
		
		//load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");
		
		//Retrieve the bean
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		System.out.println(theCoach.dailyWorkout());
		//Close the context
		context.close();
	}

}
