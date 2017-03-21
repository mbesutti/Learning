package com.mbesutti.seminarweb.controllers;

import java.util.HashMap;
import java.util.Map;

import com.mbesutti.seminarweb.html.HtmlElement;
import com.mbesutti.seminarweb.html.HtmlForm;
import com.mbesutti.seminarweb.html.HtmlLink;
import com.mbesutti.seminarweb.html.HtmlPageBuilder;

public class CreateCourseController implements Controller {

	private final Map<String, String> _errors;
	private AddCourseRequestData _addCourseRequestData;

	public CreateCourseController(AddCourseRequestData addCourseRequestData, Map<String, String> errors) {
		_addCourseRequestData = addCourseRequestData;
		_errors = errors;
	}

	public CreateCourseController() {
		_errors = new HashMap<>();
	}

	@Override
	public String build() {
		HtmlPageBuilder builder = new HtmlPageBuilder(); 
		HtmlForm form = new HtmlForm("/course/add");
		form.addInput("Name", HtmlForm.TEXT, _addCourseRequestData==null?"course name":_addCourseRequestData.getName(), _errors.get("name"));
		form.addInput("Date", HtmlForm.TEXT, _addCourseRequestData==null?"15.01.2016":_addCourseRequestData.getDate(), _errors.get("date"));
		form.addInput("Description", HtmlForm.TEXT, _addCourseRequestData==null?"Description":_addCourseRequestData.getDescription(), _errors.get("description"));
		form.addInput("Location", HtmlForm.TEXT, _addCourseRequestData==null?"Location":_addCourseRequestData.getLocation(), _errors.get("location"));
		form.addInput("Seats", HtmlForm.TEXT, _addCourseRequestData==null?"0":_addCourseRequestData.getSeats(), _errors.get("seats"));
		form.addInput("Partecipants", HtmlForm.TEXT, _addCourseRequestData==null?"Partecipants (separated by comma)":_addCourseRequestData.getPartecipants(), _errors.get("partecipants"));
		form.addSubmit("Create");
		
		HtmlElement link = new HtmlLink("List", "/course");
		
		builder.add(link);
		builder.add(form);
		
		return builder.build("Create course");
	}

}
