package com.vrishank.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.vrishank.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
			Student student = new Student("Daffy", "Duck","daffy@gmail.com");
			
			//start transaction
			session.beginTransaction();
			
			
			//save object
			System.out.println("Saving....");
			System.out.println(student);
			session.save(student);
			
			//commit
			session.getTransaction().commit();
			
			
			
			//Reading from DB
			
			
			//find id
			
			System.out.println("Generated ID:- " + student.getId());
			
			
			//get a new session
			session = factory.getCurrentSession();
			
			//start transaction
			session.beginTransaction();
			
			
			//retrieve based on id
			Student tempStudent = session.get(Student.class, student.getId());
			System.out.println(tempStudent);
			
			//commit transaction
			session.getTransaction().commit();
			
		} finally {
			session.close();
		}
	}

}
