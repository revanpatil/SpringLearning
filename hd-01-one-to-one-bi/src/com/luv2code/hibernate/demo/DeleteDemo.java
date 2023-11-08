package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {

		//Create Session Factory
		SessionFactory factory = new Configuration()
									 .configure("hibernate.cfg.xml")
									 .addAnnotatedClass(Instructor.class)
									 .addAnnotatedClass(InstructorDetail.class)
									 .buildSessionFactory();
		
		//Create Session
		Session	session = factory.getCurrentSession();
		
		try {
			
			//Start the transaction
			session.beginTransaction();
			//Retrieve the Object
			int id = 2;
			Instructor tempInstructor = session.get(Instructor.class,id);			
			//delete the transaction
			//Even instructor details will be deleted becuase of Cascading.
			session.delete(tempInstructor);
			
			//Commit the transaction
			session.getTransaction().commit();
		}finally {
			factory.close();
		}

	}

}
