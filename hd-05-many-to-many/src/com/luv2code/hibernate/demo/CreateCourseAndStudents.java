package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndStudents {

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

			//create the course
			Course tempCourse = new Course("Pacman - How to score one millio points");
			//save the course
			System.out.println("Saving the Course");
			session.save(tempCourse);
			System.out.println("Saved the course");

			//Create the students
			Student tempStudent1 = new Student("John","Doe","John@Luv2Code.com");
			Student tempStudent2 = new Student("Mary","Public","Mary@Luv2Code.com");

			//Add the student to the course
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);


			//save the students 
			System.out.println("Saving the Students");
			session.save(tempStudent1);
			session.save(tempStudent2);
			System.out.println("Students saved" +tempCourse.getStudents());

			//Commit the transaction
			session.getTransaction().commit();
		}finally {

			//add clean up code
			session.close();
			factory.close();
		}

	}

}
