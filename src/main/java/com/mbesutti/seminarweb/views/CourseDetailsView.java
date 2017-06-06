package com.mbesutti.seminarweb.views;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mbesutti.seminarweb.controllers.CourseController;
import com.mbesutti.seminarweb.html.HtmlLabel;
import com.mbesutti.seminarweb.html.HtmlNewLine;
import com.mbesutti.seminarweb.html.HtmlPageBuilder;
import com.mbesutti.seminarweb.seminar.Seminar;

public class CourseDetailsView implements View {

	@Override
	public String build(HttpServletRequest request, HttpServletResponse response, Connection connection) {
		String uri = request.getRequestURI();
		int id = Integer.parseInt(uri.substring(uri.lastIndexOf("/")+1, uri.length()));
		Seminar seminar = CourseController.single(connection, id);
		
		HtmlPageBuilder builder = new HtmlPageBuilder();
		builder.add(new HtmlLabel("Name: "+seminar.getCourse().getName()));
		builder.add(new HtmlNewLine());
		builder.add(new HtmlLabel("Date: "+seminar.getCourse().getDate()));
		builder.add(new HtmlNewLine());
		builder.add(new HtmlLabel("Description: "+seminar.getCourse().getDescription()));
		builder.add(new HtmlNewLine());
		builder.add(new HtmlLabel("Location: "+seminar.getLocation()));
		builder.add(new HtmlNewLine());
		builder.add(new HtmlLabel("Seats left: "+seminar.getSeatsLeft()+""));
//		builder.add(new HtmlNewLine());
//		builder.add(new HtmlLabel("Partecipants: "+org.sqlite.util.StringUtils.join(seminar.getStudentsNamesList(), ",")));
		
		return builder.build("Course details");
	}

}
