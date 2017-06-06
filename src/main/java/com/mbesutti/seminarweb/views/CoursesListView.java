package com.mbesutti.seminarweb.views;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mbesutti.seminarweb.controllers.CourseController;
import com.mbesutti.seminarweb.html.HtmlElement;
import com.mbesutti.seminarweb.html.HtmlLabel;
import com.mbesutti.seminarweb.html.HtmlLink;
import com.mbesutti.seminarweb.html.HtmlPageBuilder;
import com.mbesutti.seminarweb.html.HtmlSpan;
import com.mbesutti.seminarweb.html.HtmlTable;
import com.mbesutti.seminarweb.seminar.Seminar;

public class CoursesListView implements View {

	@Override
	public String build(HttpServletRequest aReq, HttpServletResponse aResp, Connection connection) {
		HtmlPageBuilder builder = new HtmlPageBuilder();
		
		HtmlTable table = new HtmlTable();
		table.setHeaders("Name", "Date", "Description", "Location", "Seats"
//				, "Partecipants"
				, "Delete");
		for (Seminar seminar : CourseController.list(connection)) {
			List<HtmlElement> row = new ArrayList<HtmlElement>();
			row.add(new HtmlLink(seminar.getCourse().getName(), "/course/"+seminar.getCourse().getId()));
			row.add(new HtmlSpan(seminar.getCourse().getDate()));
			row.add(new HtmlSpan(seminar.getCourse().getDescription()));
			row.add(new HtmlSpan(seminar.getLocation()));
			row.add(new HtmlSpan(seminar.getSeatsLeft()+""));
//			row.add(new HtmlSpan(seminar.getStudentsList().toString()));
			row.add(new HtmlLink("X", "/course/delete/"+seminar.getCourse().getId()));
			table.addRow(row);
		}
		builder.add(table);
		
		HtmlLabel label = new HtmlLabel("Count: " + CourseController.count(connection));
		builder.add(label);

		return builder.build("Courses");
	}
}
