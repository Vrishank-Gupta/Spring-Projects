package com.vrishank.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.vrishank.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		
		//get Session factory, only one in the project
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();

		
		//get session
		
		Session session = factory.getCurrentSession();
		
		try {
			//save the object in database
			
			//create student object
			Student student = new Student("Vrishank", "Gupta","vrishank98@gmail.com");
			
			//start transaction
			session.beginTransaction();
			
			
			//save object
			System.out.println("Saving....");
			session.save(student);
			
			//commit
			session.getTransaction().commit();
			
		} finally {
			session.close();
		}
	}

}
