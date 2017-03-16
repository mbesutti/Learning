package com.mbesutti.seminarweb.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mbesutti.seminarweb.controllers.AddCourseController;
import com.mbesutti.seminarweb.controllers.AddCourseRequestData;
import com.mbesutti.seminarweb.controllers.CoursesListController;
import com.mbesutti.seminarweb.controllers.CreateCourseController;
import com.mbesutti.seminarweb.html.HtmlNotFound;
import com.mbesutti.seminarweb.html.HtmlPageBuilder;
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
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(req.getRequestURI().equals("/course/create") || req.getRequestURI().equals("/course/create/")){
			CreateCourseController createCourseController = new CreateCourseController();
			resp.getWriter().write(createCourseController.build());
			resp.setStatus(HttpServletResponse.SC_OK);
		}
		
		else if(req.getRequestURI().equals("/course") || req.getRequestURI().equals("/course/")){
			CoursesListController coursesListController = new CoursesListController(_seminarsRepo);
			resp.getWriter().write(coursesListController.build());

			resp.setStatus(HttpServletResponse.SC_OK);
		}

		else if(req.getRequestURI().equals("/course/add")){
			
			AddCourseRequestData addCourseRequestData = new AddCourseRequestData()
					.setName(req.getParameter("name"))
					.setDescription(req.getParameter("description"))
					.setDate(req.getParameter("date"))
					.setSeats(req.getParameter("seats"))
					.setLocation(req.getParameter("location"))
					.setPartecipants(req.getParameter("partecipants"));
			Map<String, String> errors = addCourseRequestData.validate();
			System.out.println("errors: "+!errors.isEmpty());
			if (!errors.isEmpty()){
				CreateCourseController createCourseController = new CreateCourseController(addCourseRequestData, errors);
				resp.getWriter().write(createCourseController.build());
				resp.setStatus(HttpServletResponse.SC_OK);
				return;
			}
			
			AddCourseController addCourseController = new AddCourseController(_seminarsRepo, addCourseRequestData);
			addCourseController.build();
			
			resp.sendRedirect("/course");
		}
		
		else{
			HtmlPageBuilder builder = new HtmlPageBuilder(); 
			HtmlNotFound notFoundPage = new HtmlNotFound();
			notFoundPage.addRedirectLink("Course list", "/course");
			notFoundPage.addRedirectLink("Create course", "/course/create");
			builder.add(notFoundPage);
			
			resp.getWriter().write(
				builder.build("")
			);
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
	}
}
