package com.vrishank.operations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vrishank.utils.Course;
import com.vrishank.utils.Instructor;
import com.vrishank.utils.InstructorDetail;

public class CreateCoursesDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();

		
		Session session = factory.getCurrentSession();
		
		
		try {
			
			
			
			session.beginTransaction();
			
			//get instr from db
			int id =1;
			Instructor instructor = session.get(Instructor.class, id);
			
			
			//create courses
			Course course1 = new Course("Course 1");
			Course course2 = new Course("Course 2");

			
			//add courses to instr
			
			instructor.add(course1);
			instructor.add(course2);
			
			//save courses
			session.save(course1);
			session.save(course2);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.close();
			factory.close();
		}
	}

}
