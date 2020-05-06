package com.vrishank.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vrishank.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

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
			
			//create 3 students object
			Student student1 = new Student("Bablu", "Gupta","bablubhai@gmail.com");
			Student student2 = new Student("Chhotu", "Kumar","chhotu1223@yahoo.com.com");
			Student student3 = new Student("Dipu", "Budhi","budhiboyz_8@gmail.com");
			
			//start transaction
			session.beginTransaction();
			
			
			//save object
			System.out.println("Saving....");
			session.save(student1);
			session.save(student2);
			session.save(student3);

			//commit
			session.getTransaction().commit();
			
		} finally {
			session.close();
		}

	}

}
