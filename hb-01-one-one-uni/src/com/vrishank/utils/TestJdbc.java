package com.vrishank.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		String urlString = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
		String user = "hbstudent";
		String password = "hbstudent";
		
		
		try {
			Connection connection = DriverManager.getConnection(urlString,user,password);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	

	}

}
