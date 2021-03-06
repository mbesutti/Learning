package com.mbesutti.seminarweb.seminar;

import java.util.ArrayList;
import java.util.List;

import com.mbesutti.seminarweb.printers.SeminarPrinter;

public class Seminar {
	private String location;
	private int totalSeats = 0;
	private final ArrayList<Enrollment> enrollments;
	private final Course course;
	
	public Seminar(Course course, int totalSeats, String location) {
		this.course = course;
		this.totalSeats = totalSeats;
		this.location = location;
		enrollments = new ArrayList<Enrollment>();
	}
	
	public Seminar() {
		enrollments = new ArrayList<Enrollment>();
		course = new Course();
	}

	public void addPartecipant(Student student){
		enrollments.add(new Enrollment(student));
	}
	
	public int getSeatsLeft() {
		return totalSeats - enrollments.size();
	}
	
	public int getTotalSeats() {
		return totalSeats;
	}
	
	public List<Student> getStudentsList(){
		ArrayList<Student> students = new ArrayList<Student>();
		for (Enrollment enrollment : enrollments) {
			students.add(enrollment.student);
		}
		return students;
	}
	
	public List<String> getStudentsNamesList(){
		ArrayList<String> students = new ArrayList<String>();
		for (Student enrollment : getStudentsList()) {
			students.add(enrollment.getFullName());
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
