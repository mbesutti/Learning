package com.mbesutti.seminarweb.views;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mbesutti.seminarweb.html.HtmlNotFound;
import com.mbesutti.seminarweb.html.HtmlPageBuilder;
import com.mbesutti.seminarweb.repository.SeminarRepository;

public class NotFoundView implements View{

	@Override
	public String build(HttpServletRequest req, HttpServletResponse resp, Connection connection) {
		SeminarRepository seminarsRepo = new SeminarRepository(connection);
		
		HtmlPageBuilder builder = new HtmlPageBuilder(); 
		HtmlNotFound notFoundPage = new HtmlNotFound();
		notFoundPage.addRedirectLink("Course list", "/course");
		notFoundPage.addRedirectLink("Create course", "/course/create");
		builder.add(notFoundPage);
		
		try {
			resp.getWriter().write(
				builder.build("")
			);
		} catch (IOException e) {
			e.printStackTrace();
		}
		resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
		return "";
	}

}
