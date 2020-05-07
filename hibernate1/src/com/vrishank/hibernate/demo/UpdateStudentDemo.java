package com.vrishank.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.vrishank.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		
		//get Session factory, only one in the project
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();

		
		//get session
		
		Session session = factory.getCurrentSession();
		
		try {
			//update the single object in database
			
			int id = 1;
			
			//start transaction 
			session.beginTransaction();
			
			
			//get object
			Student student = session.get(Student.class, id);
			System.out.println(student);
			//update object
			student.setFirstName("Vishu");
			
			//commit
			session.getTransaction().commit();
			
			/////////////////////OR/////////////////////
			
			
			session = factory.getCurrentSession();
			//updating multiple
			//start transaction 
			session.beginTransaction();
		
			//create query
			session.createQuery("update Student s set s.email='vishuGupta@gmail.com' where s.firstName ='Vishu'").executeUpdate();
			
			
			//commit
			session.getTransaction().commit();
			
		} finally {
			session.close();
		}
	}

}
