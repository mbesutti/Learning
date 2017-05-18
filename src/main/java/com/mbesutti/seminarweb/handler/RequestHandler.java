package com.mbesutti.seminarweb.handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mbesutti.seminarweb.controllers.Controller;

public class RequestHandler {

	private final Map<String, Controller> _list;
	private final Controller _defaultController;

	public RequestHandler(Controller defaultController) {
		_defaultController = defaultController;
		_list = new HashMap<String, Controller>();
	}

	public void add(Controller controller, String... paths) {
		for (String path : paths) {
			_list.put(path, controller);
		}
	}
	
	public void handle(HttpServletRequest aReq, HttpServletResponse aResp) throws IOException {
		Controller controller = _list.get(aReq.getRequestURI());
		if (controller == null) {
			controller = _defaultController;
		}
		aResp.getWriter().write(controller.build(aReq, aResp));
		aResp.setStatus(HttpServletResponse.SC_OK);
	}

}
