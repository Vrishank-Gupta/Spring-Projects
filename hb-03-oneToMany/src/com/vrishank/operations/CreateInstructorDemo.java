package com.vrishank.operations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vrishank.utils.Course;
import com.vrishank.utils.Instructor;
import com.vrishank.utils.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();

		
		Session session = factory.getCurrentSession();
		
		
		try {
			
			
			Instructor instructor = new Instructor("Vrishank",
													"Gupta",
													"vrishank98@gmail.com");
			
			InstructorDetail instructorDetail = new InstructorDetail(
												"http://youtube.com/vrishank",
												"Spring Hobby");
			
			session.beginTransaction();
			
			instructor.setInstructorDetail(instructorDetail);
			
			
			//it'll also save instructorDetail as an object due to cascade
			session.save(instructor);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.close();
			factory.close();
		}
	}

}
