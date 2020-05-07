package com.vrishank.operations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.vrishank.utils.Instructor;
import com.vrishank.utils.InstructorDetail;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();

		
		Session session = factory.getCurrentSession();
		
		
		try {
			//demo to show cascade delete, deleting instructor will also delete corresponding details.
			
			session.beginTransaction();
			
			int id = 29;
			//get instructor detail object
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
			
			
			//print InstructorDetail
			System.out.println(instructorDetail);
			
			
			
			//print associated Instructor
			System.out.println(instructorDetail.getInstructor());
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}

}
