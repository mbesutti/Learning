package com.mbesutti.seminar;

import java.util.ArrayList;

import com.mbesutti.seminar.printers.SeminarPrinter;

public class Seminar {
	public String location;
	public int totalSeats;
	public ArrayList<Enrollment> enrollments;
	public Course course;
	
	public Seminar(Course course) {
		this.course = course;
		enrollments = new ArrayList<Enrollment>();
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
	
	public void print(SeminarPrinter printer) {
		printer.print(this);
	}
}
