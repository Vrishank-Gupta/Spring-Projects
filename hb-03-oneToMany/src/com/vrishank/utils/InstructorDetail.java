package com.vrishank.utils;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name= "youtube_channel")
	private String youtube_channel;
	
	@Column(name = "hobby")
	private String hobby;

//	@OneToOne(mappedBy = "instructorDetail",cascade = CascadeType.ALL) //for cascading all operations
	
	
	//for all operations except delete
	@OneToOne(mappedBy = "instructorDetail",
			cascade = {CascadeType.MERGE,CascadeType.REFRESH, CascadeType.DETACH, CascadeType.PERSIST})  //from instructorDetail field in Instructor class, now its bidirectional mapping
	private Instructor instructor;

	
	
	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public InstructorDetail() {
		
	}
	
	public InstructorDetail(String youtube_channel, String hobby) {
		super();
		this.youtube_channel = youtube_channel;
		this.hobby = hobby;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getYoutube_channel() {
		return youtube_channel;
	}


	public void setYoutube_channel(String youtube_channel) {
		this.youtube_channel = youtube_channel;
	}


	public String getHobby() {
		return hobby;
	}


	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtube_channel=" + youtube_channel + ", hobby=" + hobby + "]";
	}
	
	
	
	
}
