package com.mbesutti.seminarweb.servlet;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.mbesutti.seminarweb.handler.RequestRouter;
import com.mbesutti.seminarweb.views.AddCourseView;
import com.mbesutti.seminarweb.views.CoursesListView;
import com.mbesutti.seminarweb.views.CreateCourseView;
import com.mbesutti.seminarweb.views.DeleteCourseView;
import com.mbesutti.seminarweb.views.NotFoundView;
import com.mbesutti.seminarweb.views.UpdateCourseView;

@SuppressWarnings("serial")
public class Servlet extends HttpServlet {
	private RequestRouter _requestRouter;
	
	@Override
	public void init() throws ServletException {
		super.init();
		_requestRouter = new RequestRouter(new NotFoundView());
		_requestRouter.add(new CreateCourseView(), "/course/create", "/course/create/");
		_requestRouter.add(new CoursesListView(), "/course", "/", "^/a");
		_requestRouter.add(new AddCourseView(), "/course/add");
		_requestRouter.add(new CreateCourseView(), "^/course/\\d$");
		_requestRouter.add(new UpdateCourseView(), "^/course/update/\\d$");
		_requestRouter.add(new DeleteCourseView(), "^/course/delete/\\d$");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) {
		try {
			DataSource ds = (DataSource)new InitialContext().lookup("java:/comp/env/jdbc/ds");
			Connection connection = ds.getConnection();
			
			_requestRouter.handle(req, resp, connection);
			
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
