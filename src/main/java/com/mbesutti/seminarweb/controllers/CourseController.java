package com.mbesutti.seminarweb.controllers;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mbesutti.seminarweb.repository.SeminarRepository;
import com.mbesutti.seminarweb.seminar.Course;
import com.mbesutti.seminarweb.seminar.Seminar;
import com.mbesutti.seminarweb.seminar.Student;

public class CourseController {
	public static List<Seminar> list(Connection connection){
		SeminarRepository seminarsRepo = new SeminarRepository(connection);
		return seminarsRepo.getSeminars();
	}
	
	public static Seminar single(Connection connection, int id){
		SeminarRepository seminarsRepo = new SeminarRepository(connection);
		return seminarsRepo.getSeminar(id);
	}
	
	public static int count(Connection connection){
		SeminarRepository seminarsRepo = new SeminarRepository(connection);
		return seminarsRepo.count();
	}
	
	public static Map<String, String> add(Connection connection, CourseRequestData courseRequestData){
		Map<String, String> errors = courseRequestData.validate();
		if (!errors.isEmpty()){
			return errors;
		}
		
		SeminarRepository seminarsRepo = new SeminarRepository(connection);
		
		Integer seats = Integer.parseInt(courseRequestData.getSeats());
		Course course = new Course(courseRequestData.getName(), courseRequestData.getDescription(), courseRequestData.getDate());
		Seminar seminar = new Seminar(course, seats, courseRequestData.getLocation());
		String partecipants = courseRequestData.getPartecipants();
		if (!partecipants.isEmpty()) {
			for (String person : partecipants.split(",")) {
				person = person.trim();
				String firstName = person.substring(0, person.indexOf(" ")).trim();
				String lastName = person.substring(person.indexOf(" ")).trim();
				Student student = new Student(firstName, lastName);
				seminar.addPartecipant(student);
			}
		}
		seminarsRepo.add(seminar);
		
		return new HashMap<String, String>();
	}

	public static void delete(Connection connection, int id) {
		SeminarRepository seminarsRepo = new SeminarRepository(connection);
		seminarsRepo.delete(id);
	}

	public static Map<String, String> update(Connection connection, int id, CourseRequestData courseRequestData) {
		Map<String, String> errors = courseRequestData.validate();
		if (!errors.isEmpty()){
			return errors;
		}
		
		SeminarRepository seminarsRepo = new SeminarRepository(connection);
		
		Integer seats = Integer.parseInt(courseRequestData.getSeats());
		Course course = new Course(courseRequestData.getName(), courseRequestData.getDescription(), courseRequestData.getDate());
		Seminar seminar = new Seminar(course, seats, courseRequestData.getLocation());
//		String partecipants = courseRequestData.getPartecipants();
//		if (!partecipants.isEmpty()) {
//			for (String person : partecipants.split(",")) {
//				person = person.trim();
//				String firstName = person.substring(0, person.indexOf(" ")).trim();
//				String lastName = person.substring(person.indexOf(" ")).trim();
//				Student student = new Student(firstName, lastName);
//				seminar.addPartecipant(student);
//			}
//		}
		seminar.getCourse().setId(id+"");
		seminarsRepo.update(seminar);
		
		return new HashMap<String, String>();		
	}
}
