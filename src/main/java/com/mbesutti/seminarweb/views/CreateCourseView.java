package com.mbesutti.seminarweb.views;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mbesutti.seminarweb.controllers.CourseController;
import com.mbesutti.seminarweb.controllers.CourseRequestData;
import com.mbesutti.seminarweb.html.HtmlForm;
import com.mbesutti.seminarweb.html.HtmlPageBuilder;
import com.mbesutti.seminarweb.seminar.Seminar;

public class CreateCourseView implements View {

	private final Map<String, String> _errors;
	private CourseRequestData _addCourseRequestData;

	public CreateCourseView(Map<String, String> errors, CourseRequestData addCourseRequestData) {
		_errors = errors;
		_addCourseRequestData = addCourseRequestData;
	}

	public CreateCourseView() {
		_errors = new HashMap<String,String>();
	}

	@Override
	public String build(HttpServletRequest req, HttpServletResponse res, Connection connection) {
		String action = "add";
		
		try {
			String uri = req.getRequestURI();
			String stringId = uri.substring(uri.lastIndexOf("/")+1, uri.length());
			int id = Integer.parseInt(stringId);
			Seminar seminar = CourseController.single(connection, id);
			_addCourseRequestData = parseSeminar(seminar);
			action = "update/"+id;
		}
		catch (NumberFormatException e) {
		}
		
		HtmlPageBuilder builder = new HtmlPageBuilder();
		HtmlForm form = new HtmlForm("/course/"+action);
		form.addInput("Name", HtmlForm.TEXT, "course name", _addCourseRequestData!=null?_addCourseRequestData.getName():"", _errors.get("name"));
		form.addInput("Date", HtmlForm.TEXT, "15.01.2016", _addCourseRequestData!=null?_addCourseRequestData.getDate():"", _errors.get("date"));
		form.addInput("Description", HtmlForm.TEXT, "Description", _addCourseRequestData!=null?_addCourseRequestData.getDescription():"", _errors.get("description"));
		form.addInput("Location", HtmlForm.TEXT, "Location", _addCourseRequestData!=null?_addCourseRequestData.getLocation():"", _errors.get("location"));
		form.addInput("Seats", HtmlForm.TEXT, "0", _addCourseRequestData!=null?_addCourseRequestData.getSeats():"", _errors.get("seats"));
		form.addSubmit("Save");
		
		builder.add(form);
		
		int indexOf = action.indexOf("/");
		return builder.build(action.substring(0, indexOf > 0 ? indexOf : action.length()) + " course");
	}

	private CourseRequestData parseSeminar(Seminar seminar) {
		return new CourseRequestData()
				.setName(seminar.getCourse().getName())
				.setDescription(seminar.getCourse().getDescription())
				.setDate(seminar.getCourse().getDate())
				.setSeats(seminar.getTotalSeats()+"")
				.setLocation(seminar.getLocation())
				.setPartecipants(org.sqlite.util.StringUtils.join(seminar.getStudentsNamesList(), ","));
	}
}
