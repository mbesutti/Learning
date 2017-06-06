package com.mbesutti.seminarweb.seminar;

public class Course {
	private String id;
	private String name;
	private String description;
	private String date;
	
	public Course(String id, String name, String description, String date) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.date = date;
	}
	
	public Course(String name, String description, String date) {
		this.id = null;
		this.name = name;
		this.description = description;
		this.date = date;
	}

	public Course() {
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getDate() {
		return date;
	}

	public String getId() {
		return id;
	}
}