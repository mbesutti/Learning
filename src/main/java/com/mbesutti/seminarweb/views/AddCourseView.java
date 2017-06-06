package com.mbesutti.seminarweb.views;

import java.io.IOException;
import java.sql.Connection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mbesutti.seminarweb.controllers.AddCourseRequestData;
import com.mbesutti.seminarweb.controllers.CourseController;
import com.mbesutti.seminarweb.repository.SeminarRepository;

public class AddCourseView implements View {

	@Override
	public String build(HttpServletRequest req, HttpServletResponse resp, Connection connection) {
		SeminarRepository seminarsRepo = new SeminarRepository(connection);
		
		AddCourseRequestData addCourseRequestData = parseRequest(req);
		
		Map<String, String> errors = CourseController.add(connection, addCourseRequestData);
		
		if (!errors.isEmpty()) {
			CreateCourseView createCourseView = new CreateCourseView(errors, addCourseRequestData);
			try {
				resp.getWriter().write(createCourseView.build(req, resp, connection));
			} catch (IOException e) {
				e.printStackTrace();
			}
			resp.setStatus(HttpServletResponse.SC_OK);
			return "";
		}
		
		try {
			resp.sendRedirect("/course");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "";
	}

	private AddCourseRequestData parseRequest(HttpServletRequest req) {
		AddCourseRequestData addCourseRequestData = new AddCourseRequestData()
				.setName(req.getParameter("name"))
				.setDescription(req.getParameter("description"))
				.setDate(req.getParameter("date"))
				.setSeats(req.getParameter("seats"))
				.setLocation(req.getParameter("location"))
				.setPartecipants(req.getParameter("partecipants"));
		return addCourseRequestData;
	}
}
