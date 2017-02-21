package com.mbesutti.seminarweb.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mbesutti.seminarweb.printers.HtmlSeminarPrinter;
import com.mbesutti.seminarweb.html.HtmlElement;
import com.mbesutti.seminarweb.html.HtmlForm;
import com.mbesutti.seminarweb.html.HtmlLink;
import com.mbesutti.seminarweb.html.HtmlNotFound;
import com.mbesutti.seminarweb.html.HtmlPageBuilder;
import com.mbesutti.seminarweb.html.HtmlTable;
import com.mbesutti.seminarweb.printers.SeminarPrinter;
import com.mbesutti.seminarweb.repository.SeminarRepository;
import com.mbesutti.seminarweb.seminar.Course;
import com.mbesutti.seminarweb.seminar.Seminar;
import com.mbesutti.seminarweb.seminar.Student;

@SuppressWarnings("serial")
public class Servlet extends HttpServlet {
	private SeminarRepository _seminarsRepo;
	
	@Override
	public void init() throws ServletException {
		super.init();
		_seminarsRepo = new SeminarRepository();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(req.getRequestURI().equals("/course/create") || req.getRequestURI().equals("/course/create/")){
			HtmlPageBuilder builder = new HtmlPageBuilder(); 
			HtmlForm form = new HtmlForm("/course/add");
			form.addInput("Name", HtmlForm.TEXT, "Course name");
			form.addInput("Date", HtmlForm.TEXT, "15.01.2016");
			form.addInput("Description", HtmlForm.TEXT, "Description");
			form.addInput("Location", HtmlForm.TEXT, "Location");
			form.addInput("Seats", HtmlForm.TEXT, "Total seats available");
			form.addInput("Partecipants", HtmlForm.TEXT, "Partecipants (separated by comma)");
			form.addSubmit("Create");
			
			HtmlElement link = new HtmlLink("List", "/course");
			
			builder.add(link);
			builder.add(form);
			resp.getWriter().write(
			    builder.build("Create course")
		    );
			resp.setStatus(HttpServletResponse.SC_OK);
		}
		
		else if(req.getRequestURI().equals("/course") || req.getRequestURI().equals("/course/")){
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

			resp.getWriter().write(
				builder.build("Courses")
			);
			resp.setStatus(HttpServletResponse.SC_OK);
		}
		
		else{
			HtmlPageBuilder builder = new HtmlPageBuilder(); 
			HtmlNotFound notFoundPage = new HtmlNotFound();
			notFoundPage.addRedirect("Course list", "/course");
			notFoundPage.addRedirect("Create course", "/course/create");
			builder.add(notFoundPage);
			
			resp.getWriter().write(
					builder.build("")
			);
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		if(req.getRequestURI().equals("/course/add")){
			
			String name = req.getParameter("name");
			String description = req.getParameter("description");
			String date = req.getParameter("date");
			Course course = new Course(1, name, description, date);
			int seats = Integer.parseInt(req.getParameter("seats"));
			String location = req.getParameter("location");
			Seminar seminar = new Seminar(course, seats, location);
			for (String person : req.getParameter("partecipants").split(",")) {
				person = person.trim();
				String firstName = person.substring(0, person.indexOf(" ")).trim();
				String lastName = person.substring(person.indexOf(" ")).trim();
				Student student = new Student(firstName, lastName);
				seminar.addPartecipant(student );
			}
			_seminarsRepo.add(seminar);
			
			res.sendRedirect("/course");
		}
	}
}
