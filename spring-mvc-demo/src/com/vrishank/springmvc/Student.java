package com.vrishank.springmvc;

import java.util.HashMap;

public class Student {
	String firstName;
	String lastName;
	String country;
	
	private HashMap<String, String> countryOptions;
	private String[] operatingSystems;
	
	
	public Student() {
		countryOptions = new HashMap<>();
		countryOptions.put("BR", "Brazil");
		countryOptions.put("IN", "India");
		countryOptions.put("US", "USA");


	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public HashMap<String, String> getCountryOptions() {
		return countryOptions;
	}


	public String[] getOperatingSystems() {
		return operatingSystems;
	}


	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}
	
	
}
