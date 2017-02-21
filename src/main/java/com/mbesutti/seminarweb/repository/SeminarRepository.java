package com.mbesutti.seminarweb.repository;

import java.util.ArrayList;
import java.util.List;

import com.mbesutti.seminarweb.seminar.Course;
import com.mbesutti.seminarweb.seminar.Seminar;
import com.mbesutti.seminarweb.seminar.Student;

public class SeminarRepository {

	private List<Seminar> _seminars;

	public SeminarRepository() {
		_seminars = new ArrayList<Seminar>();
		Course course = new Course(1, "Lonely Course", "A description", "15.03.2017");
		Seminar seminar = new Seminar(course, 5, "Hawaii");
		seminar.addPartecipant(new Student("John", "Smith"));
		seminar.addPartecipant(new Student("Julia", "Parker"));
		
		Course course1 = new Course(1, "Second Course", "A description", "15.03.2017");
		Seminar seminar1 = new Seminar(course1, 5, "Hawaii");
		seminar1.addPartecipant(new Student("Peter", "Smith"));
		seminar1.addPartecipant(new Student("Franca", "Parker"));
		
		_seminars.add(seminar);
		_seminars.add(seminar1);
	}
	
	public List<Seminar> getSeminars() {
		return _seminars;
	}

	public void add(Seminar seminar) {
		_seminars.add(seminar);
	}
	
}
