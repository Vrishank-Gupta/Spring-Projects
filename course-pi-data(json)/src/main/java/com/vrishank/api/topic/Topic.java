package com.vrishank.api.topic;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity    //tells that it is an entity class for database for JPA
public class Topic {

	@Id    //primary key specification
	private String id;
	
	
	private String name;	
	private String description;
	
	
	
	

	public Topic() {
		
	}


	public Topic(String name, String id, String description) {
		this.name = name;
		this.id = id;
		this.description = description;
	}
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	
	
}
