package com.luv2code.hibernate.demo;

import javax.sound.midi.Soundbank;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class GetCourseAndReviewsDemo {

	public static void main(String[] args) {

		//Create Session Factory
		SessionFactory factory = new Configuration()
									 .configure("hibernate.cfg.xml")
									 .addAnnotatedClass(Instructor.class)
									 .addAnnotatedClass(InstructorDetail.class)
									 .addAnnotatedClass(Course.class)
									 .addAnnotatedClass(Review.class)
									 .buildSessionFactory();
		
		//Create Session
		Session	session = factory.getCurrentSession();
		
		try {
			
			//Begin the session
			session.beginTransaction();
			
			int theId = 10;
			
			// Retrive the course
			Course tempCourse = session.get(Course.class, theId);
			
			//Print the Course Name 
			System.out.println(tempCourse);
			
			//Print the review
			System.out.println(tempCourse.getReviews());
			
			
			
			//Commit the transaction
			session.getTransaction().commit();
		}finally {
			
			//add clean up code
			session.close();
			factory.close();
		}

	}

}
