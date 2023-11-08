package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndReviewsDemo {

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
			
			//create the course
			Course tempCourse = new Course("Pacman - How to score one millio points");
			
			//add some reviews 
			
			tempCourse.addReview(new Review("Good Course-Job well done"));
			tempCourse.addReview(new Review("Bad Course-Job well done"));
			tempCourse.addReview(new Review("Worst Course-Job well done"));
			
			
			//save the course and leverage the cascade all
			System.out.println("Saving the course");
			System.out.println(tempCourse);
			System.out.println(tempCourse.getReviews());
			session.save(tempCourse);
			
			
			//Commit the transaction
			session.getTransaction().commit();
		}finally {
			
			//add clean up code
			session.close();
			factory.close();
		}

	}

}
