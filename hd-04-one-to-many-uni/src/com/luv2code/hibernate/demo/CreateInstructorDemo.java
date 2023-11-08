package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateInstructorDemo {

	public static void main(String[] args) {

		//Create Session Factory
		SessionFactory factory = new Configuration()
									 .configure("hibernate.cfg.xml")
									 .addAnnotatedClass(Instructor.class)
									 .addAnnotatedClass(InstructorDetail.class)
									 .addAnnotatedClass(Course.class)
									 .buildSessionFactory();
		
		//Create Session
		Session	session = factory.getCurrentSession();
		
		try {
			
			//Create the Object
			Instructor tempInstructor = new Instructor("Susan","Patel","susan@luv2Code.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("www.youtube.com","videoGames");
			
			// Associate the Object
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			// Start a Transaction 
			session.beginTransaction();
			
			// Save the instructor 
			//Note: this will also save the details object
			//becuase CASCADETYPE.ALL
			System.out.println("Saving Instructor" + tempInstructor);
			session.save(tempInstructor);
			
			
			//Commit the transaction
			session.getTransaction().commit();
		}finally {
			
			//add clean up code
			session.close();
			factory.close();
		}

	}

}
