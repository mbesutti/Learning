package com.mbesutti.seminarweb.controllers;

import com.mbesutti.seminarweb.repository.SeminarRepository;
import com.mbesutti.seminarweb.seminar.Course;
import com.mbesutti.seminarweb.seminar.Seminar;
import com.mbesutti.seminarweb.seminar.Student;

public class AddCourseController implements Controller {

	private final SeminarRepository _seminarsRepo;
	private final AddCourseRequestData _addCourseRequestData;

	public AddCourseController(SeminarRepository seminarsRepo, AddCourseRequestData addCourseRequestData) {
		_seminarsRepo = seminarsRepo;
		_addCourseRequestData = addCourseRequestData;
	}

	@Override
	public String build() {
		Integer seats = Integer.parseInt(_addCourseRequestData.getSeats());
		Course course = new Course(1, _addCourseRequestData.getName(), _addCourseRequestData.getDescription(), _addCourseRequestData.getDate());
		Seminar seminar = new Seminar(course, seats, _addCourseRequestData.getLocation());
		for (String person : _addCourseRequestData.getPartecipants().split(",")) {
			person = person.trim();
			String firstName = person.substring(0, person.indexOf(" ")).trim();
			String lastName = person.substring(person.indexOf(" ")).trim();
			Student student = new Student(firstName, lastName);
			seminar.addPartecipant(student );
		}
		_seminarsRepo.add(seminar);

		return "";
	}
}
