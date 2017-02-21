package com.mbesutti.seminarweb.seminar;

import java.util.ArrayList;

import com.mbesutti.seminarweb.printers.SeminarPrinter;

public class Seminar {
	private String location;
	private int totalSeats;
	private ArrayList<Enrollment> enrollments;
	private Course course;
	
	public Seminar(Course course, int totalSeats, String location) {
		this.course = course;
		this.totalSeats = totalSeats;
		this.location = location;
		enrollments = new ArrayList<Enrollment>();
	}
	
	public void addPartecipant(Student student){
		enrollments.add(new Enrollment(student));
	}
	
	public int getSeatsLeft() {
		return totalSeats - enrollments.size();
	}
	
	public ArrayList<Student> getStudentsList(){
		ArrayList<Student> students = new ArrayList<Student>();
		for (Enrollment enrollment : enrollments) {
			students.add(enrollment.student);
		}
		return students;
	}
	
	public String print(SeminarPrinter printer) {
		return printer.print(this);
	}
	
	public Course getCourse(){
		return course;
	}

	public String getLocation() {
		return location;
	}
}
