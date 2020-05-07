package com.vrishank.operations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.vrishank.utils.Instructor;
import com.vrishank.utils.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();

		
		Session session = factory.getCurrentSession();
		
		
		try {
			//demo to show cascade delete, deleting instructor will also delete corresponding details.
			
			session.beginTransaction();
			
			int id = 1;
			
			Instructor instructor = session.get(Instructor.class, id);
			
			System.out.println(instructor);
			
			if(instructor != null) {
				session.delete(instructor);
			}
			
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
