package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseDemo {

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
			
			//Begin the session
			session.beginTransaction();
			
			//Get the instructor from DB
			int theid = 1;
			
			Instructor tempInstructor = session.get(Instructor.class, theid);
			
			//Create some Courses
			Course tempCourse1 = new Course("Air Guitar");
			Course tempCourse2 = new Course("JAVA");
			
			// Add Courses from instructor
			
			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);
			
			//Save the courses
			
			session.save(tempCourse1);
			session.save(tempCourse2);
			
			//Commit the transaction
			session.getTransaction().commit();
		}finally {
			
			//add clean up code
			session.close();
			factory.close();
		}

	}

}
