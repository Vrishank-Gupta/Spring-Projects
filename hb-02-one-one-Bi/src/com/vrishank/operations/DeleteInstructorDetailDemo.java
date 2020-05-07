package com.vrishank.operations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.vrishank.utils.Instructor;
import com.vrishank.utils.InstructorDetail;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();

		
		Session session = factory.getCurrentSession();
		
		
		try {
			//demo to show cascade delete, deleting instructor will also delete corresponding details.
			
			session.beginTransaction();
			
			int id = 3;
			//get instructor detail object
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
			
			
			instructorDetail.getInstructor().setInstructorDetail(null); //for breaking bidirectional linking
			//print InstructorDetail
			System.out.println(instructorDetail);
			
			
			
			//print associated Instructor
			System.out.println(instructorDetail.getInstructor());
			
			
			//cascade Delete instructor as well//only when cascadetype.all is selected in class definition
			session.delete(instructorDetail);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}

}
