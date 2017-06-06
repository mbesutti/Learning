package com.mbesutti.seminarweb.views;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mbesutti.seminarweb.controllers.CourseController;

public class DeleteCourseView implements View {

	@Override
	public String build(HttpServletRequest request, HttpServletResponse response, Connection connection) {
		String uri = request.getRequestURI();
		int id = Integer.parseInt(uri.substring(uri.lastIndexOf("/")+1, uri.length()));
		CourseController.delete(connection, id);
		
		try {
			response.sendRedirect("/course");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "";
	}

}
