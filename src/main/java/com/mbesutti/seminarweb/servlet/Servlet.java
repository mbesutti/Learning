package com.mbesutti.seminarweb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mbesutti.seminarweb.controllers.AddCourseController;
import com.mbesutti.seminarweb.controllers.CoursesListController;
import com.mbesutti.seminarweb.controllers.CreateCourseController;
import com.mbesutti.seminarweb.controllers.NotFoundController;
import com.mbesutti.seminarweb.handler.RequestHandler;
import com.mbesutti.seminarweb.repository.SeminarRepository;

@SuppressWarnings("serial")
public class Servlet extends HttpServlet {
	private SeminarRepository _seminarsRepo;
	
	@Override
	public void init() throws ServletException {
		super.init();
		_seminarsRepo = new SeminarRepository();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		RequestHandler requestHandler = new RequestHandler(new NotFoundController());
		requestHandler.add(new CreateCourseController(), "/course/create", "/course/create/");
		requestHandler.add(new CoursesListController(_seminarsRepo), "/course", "/");
		requestHandler.add(new AddCourseController(_seminarsRepo), "/course/add");
		
		requestHandler.handle(req, resp);
	}
}
