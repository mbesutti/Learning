package com.mbesutti.seminarweb.views;

import java.io.IOException;
import java.sql.Connection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mbesutti.seminarweb.controllers.CourseController;
import com.mbesutti.seminarweb.controllers.CourseRequestData;
import com.mbesutti.seminarweb.repository.SeminarRepository;

public class UpdateCourseView implements View {

	@Override
	public String build(HttpServletRequest req, HttpServletResponse resp, Connection connection) {
		String uri = req.getRequestURI();
		int id = Integer.parseInt(uri.substring(uri.lastIndexOf("/")+1, uri.length()));
		
		SeminarRepository seminarsRepo = new SeminarRepository(connection);
		
		CourseRequestData courseRequestData = parseRequest(req);
		Map<String, String> errors = CourseController.update(connection, id, courseRequestData);
		
		if (!errors.isEmpty()) {
			CreateCourseView createCourseView = new CreateCourseView(errors, courseRequestData);
			try {
				resp.getWriter().write(createCourseView.build(req, resp, connection));
				resp.setStatus(HttpServletResponse.SC_OK);
				return "";
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			resp.sendRedirect("/course");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	private CourseRequestData parseRequest(HttpServletRequest req) {
		CourseRequestData addCourseRequestData = new CourseRequestData()
				.setName(req.getParameter("name"))
				.setDescription(req.getParameter("description"))
				.setDate(req.getParameter("date"))
				.setSeats(req.getParameter("seats"))
				.setLocation(req.getParameter("location"))
				;
		return addCourseRequestData;
	}

}
