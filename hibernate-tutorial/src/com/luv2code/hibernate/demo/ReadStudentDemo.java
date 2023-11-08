package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		//Create Session Factory
		SessionFactory factory = new Configuration()
									 .configure("hibernate.cfg.xml")
									 .addAnnotatedClass(Student.class)
									 .buildSessionFactory();
		
		//Create Session
		Session	session = factory.getCurrentSession();
		
		try {
			
		//Use the session object to java object
			//Create Student Object
			System.out.println("Creating Student Object");
			Student tempStudent = new Student("Daffy","Duck","daffy@gmail.com");
			
			
			// Start a Transaction 
			session.beginTransaction();
			
			// Save the Student Object
			System.out.println("Saving the student object");
			session.save(tempStudent);
			
			//Commit the transaction
			session.getTransaction().commit();
		
			
			//My new Code : Read Data 
			
			//find out : student's id 
			
			System.out.println("Saved Student. Generated id : "+tempStudent.getId());
			
			//Now get the session start the session 
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//Retrieve the student based on it's id: primary
			System.out.println("\n Getting the student id "+tempStudent.getId());
			Student myStudent = session.get(Student.class,tempStudent.getId());
			System.out.println("The object "+myStudent);
			
			//commit the transaction 
			session.getTransaction().commit();
			System.out.println("Done !");
			
		}finally {
			factory.close();
		}

	}

}
