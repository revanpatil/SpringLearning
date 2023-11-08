package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class AddCoursesForMary {

	public static void main(String[] args) {

		//Create Session Factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		//Create Session
		Session	session = factory.getCurrentSession();

		try {

			//Begin the session
			session.beginTransaction();
			
			//retrive mary from database
			int theId =2;
			Student tempStudent = session.get(Student.class,theId);
			
			System.out.println("\n load students"+tempStudent);
			System.out.println("Get Student COurses" +tempStudent.getCourses());
			// create new cources
			Course tempCourse1 = new Course("Rubik - Solve Cube");
			Course tempCourse2 = new Course("Atari 2600 - Game Development");
			
			//Assign the courses to mary
			
			tempCourse1.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);
			
			// save 
			session.save(tempCourse1);
			session.save(tempCourse2);
			System.out.println(tempStudent);
			System.out.println(tempCourse1);
			System.out.println(tempCourse2);
			
			//Commit the transaction
			session.getTransaction().commit();
		}finally {

			//add clean up code
			session.close();
			factory.close();
		}

	}

}
