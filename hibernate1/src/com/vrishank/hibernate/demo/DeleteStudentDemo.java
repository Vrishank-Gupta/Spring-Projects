package com.vrishank.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.vrishank.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		
		//get Session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();

		
		//get session
		
		Session session = factory.getCurrentSession();
		
		try {
			//Delete the object from database
			int id = 2;

			//start transaction
			session.beginTransaction();
			
			//get student object and delete approach 1
			Student student = session.get(Student.class, id);
			System.out.println(student);
//			session.delete(student);
			
			
			
			//approach 2
			session.createQuery("delete from Student where id=3").executeUpdate();
			
			System.out.println("Deleted..");
			
			//commit
			session.getTransaction().commit();
			
		} finally {
			session.close();
		}
	}

}
