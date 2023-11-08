package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		//Create Session Factory
		SessionFactory factory = new Configuration()
									 .configure("hibernate.cfg.xml")
									 .addAnnotatedClass(Student.class)
									 .buildSessionFactory();
		
		//Create Session
		Session	session = factory.getCurrentSession();
		
		try {
			
			int studentId = 1;
			// Start a Transaction 
			session.beginTransaction();
			
			//get the session 
			Student myStudent = session.get(Student.class, studentId);
		
			//Update the transaction
			myStudent.setFirstName("Scooby");
			
			//Commit the transaction
			session.getTransaction().commit();
		
			// Start a Transaction 
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// Bulk Update 
			session.createQuery("update Student set email= 'foo@gmail.com'")
			.executeUpdate();
			
			//Commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done !");
			
		}finally {
			factory.close();
		}

	}

}
