package com.vrishank.operations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.vrishank.utils.Employee;

public class SaveObject {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class).buildSessionFactory();

		
		Session session = factory.getCurrentSession();
		
		
		try {
			Employee employee = new Employee("Vrishank", "Gupta", "Goibibo");
			session.beginTransaction();
			
			
			session.save(employee);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
