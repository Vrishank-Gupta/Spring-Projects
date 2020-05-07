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
			
			//get instructor detail object
			
			
			//print InstructorDetail
			
			
			
			//print associated Instructor
			
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
