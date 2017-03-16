package com.mbesutti.seminarweb.controllers;

import com.mbesutti.seminarweb.html.HtmlElement;
import com.mbesutti.seminarweb.html.HtmlLink;
import com.mbesutti.seminarweb.html.HtmlPageBuilder;
import com.mbesutti.seminarweb.html.HtmlTable;
import com.mbesutti.seminarweb.repository.SeminarRepository;
import com.mbesutti.seminarweb.seminar.Seminar;

public class CoursesListController implements Controller {

	private final SeminarRepository _seminarsRepo;

	public CoursesListController(SeminarRepository seminarsRepo) {
		_seminarsRepo = seminarsRepo;
	}

	@Override
	public String build() {
		HtmlPageBuilder builder = new HtmlPageBuilder();
		HtmlTable table = new HtmlTable();
		table.setHeaders("Name", "Date", "Description", "Location", "Seats", "Partecipants");
		for (Seminar seminar : _seminarsRepo.getSeminars()) {
			table.addRow(seminar.getCourse().getName(), seminar.getCourse().getDate(), seminar.getCourse().getDescription(), seminar.getLocation(), seminar.getSeatsLeft()+"",
					seminar.getStudentsList().toString());
		}

		HtmlElement link = new HtmlLink("New course", "/course/create");
		
		builder.add(link);
		builder.add(table);

		return builder.build("Create course");
	}
}
