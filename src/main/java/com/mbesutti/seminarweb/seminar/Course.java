package com.mbesutti.seminarweb.seminar;

public class Course {
	private int number;
	private String name;
	private String description;
	private String date;
	
	public Course(int number, String name, String description, String date) {
		this.number = number;
		this.name = name;
		this.description = description;
		this.date = date;
	}

	public int getNumber() {
		return number;
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
}