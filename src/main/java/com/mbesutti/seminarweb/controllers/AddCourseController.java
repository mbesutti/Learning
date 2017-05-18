package com.mbesutti.seminarweb.controllers;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mbesutti.seminarweb.repository.SeminarRepository;
import com.mbesutti.seminarweb.seminar.Course;
import com.mbesutti.seminarweb.seminar.Seminar;
import com.mbesutti.seminarweb.seminar.Student;

public class AddCourseController implements Controller {

	private final SeminarRepository _seminarsRepo;

	public AddCourseController(SeminarRepository seminarsRepo) {
		_seminarsRepo = seminarsRepo;
	}

	@Override
	public String build(HttpServletRequest req, HttpServletResponse resp) {
		AddCourseRequestData addCourseRequestData = new AddCourseRequestData()
				.setName(req.getParameter("name"))
				.setDescription(req.getParameter("description"))
				.setDate(req.getParameter("date"))
				.setSeats(req.getParameter("seats"))
				.setLocation(req.getParameter("location"))
				.setPartecipants(req.getParameter("partecipants"));
		Map<String, String> errors = addCourseRequestData.validate();
		if (!errors.isEmpty()){
			CreateCourseController createCourseController = new CreateCourseController(errors);
			try {
				resp.getWriter().write(createCourseController.build(req, resp));
			} catch (IOException e) {
				e.printStackTrace();
			}
			resp.setStatus(HttpServletResponse.SC_OK);
			return "";
		}
		
		Integer seats = Integer.parseInt(addCourseRequestData.getSeats());
		Course course = new Course(1, addCourseRequestData.getName(), addCourseRequestData.getDescription(), addCourseRequestData.getDate());
		Seminar seminar = new Seminar(course, seats, addCourseRequestData.getLocation());
		for (String person : addCourseRequestData.getPartecipants().split(",")) {
			person = person.trim();
			String firstName = person.substring(0, person.indexOf(" ")).trim();
			String lastName = person.substring(person.indexOf(" ")).trim();
			Student student = new Student(firstName, lastName);
			seminar.addPartecipant(student );
		}
		_seminarsRepo.add(seminar);
		
		try {
			resp.sendRedirect("/course");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "";
	}
}
