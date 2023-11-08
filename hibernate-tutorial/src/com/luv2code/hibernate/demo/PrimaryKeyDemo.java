package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {
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
			Student tempStudent1 = new Student("Paul","Wall","paul@gmail.com");
			Student tempStudent2 = new Student("Paulo","WallBring","paulo@gmail.com");
			Student tempStudent3 = new Student("Marry","Bum","marry@gmail.com");
			
			// Start a Transaction 
			session.beginTransaction();
			
			// Save the Student Object
			System.out.println("Saving the student object");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			//Commit the transaction
			session.getTransaction().commit();
		}finally {
			factory.close();
		}

	}
}
