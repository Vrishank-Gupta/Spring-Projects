package com.vrishank.hibernate.demo;

import org.hibernate.Session;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.vrishank.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		
		//get Session factory, only one in the project
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();

		
		//get session
		
		Session session = factory.getCurrentSession();
		
		try {
			//query the object in database
			
			

			//start transaction
			session.beginTransaction();
			
			//query students
//			List<Student> students = session.createQuery("from Student").getResultList();   //use actual class names
			
			
			
			@SuppressWarnings("unchecked")
			List<Student> students = session.createQuery("from Student s where s.lastName='Gupta' ").getResultList();   //use actual class names

			
			//display
			displayStudents(students);
					
			
			//commit
			session.getTransaction().commit();
			
		} finally {
			session.close();
		}
	}

	private static void displayStudents(List<Student> students) {
		for(Student student : students)
		{
			System.out.println(student);
		}
	}

}
