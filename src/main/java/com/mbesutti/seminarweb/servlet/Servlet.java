package com.mbesutti.seminarweb.servlet;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mbesutti.seminar.Enrollment;
import com.mbesutti.seminarweb.html.HtmlForm;
import com.mbesutti.seminarweb.html.HtmlPageBuilder;
import com.mbesutti.seminarweb.printers.CsvSeminarPrinter;
import com.mbesutti.seminarweb.printers.HtmlSeminarPrinter;
import com.mbesutti.seminarweb.printers.RawSeminarPrinter;
import com.mbesutti.seminarweb.seminar.Course;
import com.mbesutti.seminarweb.seminar.Seminar;
import com.mbesutti.seminarweb.seminar.Student;

public class Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Course course = new Course(1, "Lonely Course", "A description", "15.03.2017");
		Seminar seminar = new Seminar(course, 5, "Hawaii");
		seminar.addPartecipant(new Student("John", "Smith"));
		seminar.addPartecipant(new Student("Julia", "Parker"));
		
		if(req.getRequestURI().equals("/course/html")){
			resp.getWriter().write(new HtmlSeminarPrinter().print(seminar));
		}
		
		if(req.getRequestURI().equals("/course/raw")){
			resp.getWriter().write(new RawSeminarPrinter().print(seminar));
		}
		
		if(req.getRequestURI().equals("/course/csv")){
			resp.getWriter().write(new CsvSeminarPrinter().print(seminar));
		}
		
		if(req.getRequestURI().equals("/course/csv/download")){
			resp.setContentType("text/csv");
		    resp.setHeader("Content-Disposition", "attachment; filename=\"seminar.csv\"");
		    try
		    {
		        OutputStream outputStream = resp.getOutputStream();
		        String outputResult = new CsvSeminarPrinter().print(seminar);
		        outputStream.write(outputResult.getBytes());
		        outputStream.flush();
		        outputStream.close();
		    }
		    catch(Exception e)
		    {
		        System.out.println(e.toString());
		    }
		}
		if(req.getRequestURI().equals("/course/create")){
			HtmlPageBuilder builder = new HtmlPageBuilder(); 
			HtmlForm form = new HtmlForm();
			form.addInput("Name", HtmlForm.TEXT, "Course name");
			form.addInput("Date", HtmlForm.TEXT, "15.01.2016");
			form.addInput("Description", HtmlForm.TEXT, "Description");
			form.addInput("Location", HtmlForm.TEXT, "Location");
			form.addInput("Seats", HtmlForm.TEXT, "Total seats available");
			
			builder.add(form);
			resp.getWriter().write(
			    builder.build("Create course")
		    );
		}
	}
}
