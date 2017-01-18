package com.mbesutti.seminarweb.seminar;

public class Enrollment {
	
	public Student student;

	public Enrollment(String firstName, String lastName) {
		this.student = new Student(firstName, lastName);
	}
	
	public Enrollment(Student student) {
		this.student = student;
	}
	
	public String getInfo() {
		return student.getFullName(); 
	}
}
