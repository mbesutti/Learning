package com.mbesutti.seminarweb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mbesutti.seminarweb.HtmlSeminarPrinter;
import com.mbesutti.seminarweb.RawSeminarPrinter;
import com.mbesutti.seminarweb.seminar.Course;
import com.mbesutti.seminarweb.seminar.Seminar;
import com.mbesutti.seminarweb.seminar.Student;

public class Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Course course = new Course(1, "Lonenly Course", "A description", "15.03.2017");
		Seminar seminar = new Seminar(course, 5, "Hawaii");
		seminar.addPartecipant(new Student("John", "Smith"));
		seminar.addPartecipant(new Student("Julia", "Parker"));
		
		if(req.getRequestURI().equals("/course/html")){
			resp.getWriter().write(new HtmlSeminarPrinter().print(seminar));
		}
		
		if(req.getRequestURI().equals("/course/raw")){
			resp.getWriter().write(new RawSeminarPrinter().print(seminar));
		}
	}
}
