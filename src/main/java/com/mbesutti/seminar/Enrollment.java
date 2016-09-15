package com.mbesutti.seminar;

public class Enrollment {
	
	public Student student;

	public Enrollment(Student student) {
		this.student = student;
	}
	
	public String getInfo() {
		return student.getFullName(); 
	}
}
