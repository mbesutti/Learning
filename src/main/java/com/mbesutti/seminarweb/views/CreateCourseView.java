package com.mbesutti.seminarweb.views;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mbesutti.seminarweb.controllers.AddCourseRequestData;
import com.mbesutti.seminarweb.html.HtmlForm;
import com.mbesutti.seminarweb.html.HtmlPageBuilder;

public class CreateCourseView implements View {

	private final Map<String, String> _errors;
	private AddCourseRequestData _addCourseRequestData;

	public CreateCourseView(Map<String, String> errors, AddCourseRequestData addCourseRequestData) {
		_errors = errors;
		_addCourseRequestData = addCourseRequestData;
	}

	public CreateCourseView() {
		_errors = new HashMap<String,String>();
	}

	@Override
	public String build(HttpServletRequest req, HttpServletResponse res, Connection connection) {
		HtmlPageBuilder builder = new HtmlPageBuilder();
		HtmlForm form = new HtmlForm("/course/add");
		form.addInput("Name", HtmlForm.TEXT, "course name", _addCourseRequestData!=null?_addCourseRequestData.getName():"", _errors.get("name"));
		form.addInput("Date", HtmlForm.TEXT, "15.01.2016", _addCourseRequestData!=null?_addCourseRequestData.getDate():"", _errors.get("date"));
		form.addInput("Description", HtmlForm.TEXT, "Description", _addCourseRequestData!=null?_addCourseRequestData.getDescription():"", _errors.get("description"));
		form.addInput("Location", HtmlForm.TEXT, "Location", _addCourseRequestData!=null?_addCourseRequestData.getLocation():"", _errors.get("location"));
		form.addInput("Seats", HtmlForm.TEXT, "0", _addCourseRequestData!=null?_addCourseRequestData.getSeats():"", _errors.get("seats"));
//		form.addInput("Partecipants", HtmlForm.TEXT, "Partecipants (separated by comma)", _addCourseRequestData!=null?_addCourseRequestData.getPartecipants():"", _errors.get("partecipants"));
		form.addSubmit("Save");
		
		builder.add(form);
		
		return builder.build("Create course");
	}

}
