package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		//Create Session Factory
		SessionFactory factory = new Configuration()
									 .configure("hibernate.cfg.xml")
									 .addAnnotatedClass(Student.class)
									 .buildSessionFactory();
		
		//Create Session
		Session	session = factory.getCurrentSession();
		
		try {
			
			//Query the object using HQL
			// Start a Transaction 
			session.beginTransaction();
		
			//query the object
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			//diplay the object
			
			diplayStudents(theStudents);
			
			//Displaying the Student whoose last Name is "Wall"
			System.out.println("\n\nDisplaying the Student whoose last Name is Wall");
			theStudents = session.createQuery("from Student where lastName = 'Wall'").getResultList();
			
			diplayStudents(theStudents);
			
			//Displaying the Student whoose last Name is "Wall" or FirstName = "Paulo"
			System.out.println("\n\nDisplaying the Student whoose last Name is Wall OR First Name is Paulo");
			
			theStudents = session.createQuery("from Student s where lastName='Wall' OR firstName = 'Paulo'").getResultList();
			diplayStudents(theStudents);
			
			theStudents = session.createQuery("from Student s where s.email LIKE '%gmail.com'").getResultList();
			System.out.println("\n\nDisplay email ending with gmail.com");
			
			diplayStudents(theStudents);
			
			//Commit the transaction
			session.getTransaction().commit();
		}finally {
			factory.close();
		}

	}

	private static void diplayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
