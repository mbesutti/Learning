package com.mbesutti.seminarweb.handler;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mbesutti.seminarweb.views.View;

public class RequestRouter {

	private final Map<View, String[]> _list;
	private final View _defaultController;

	public RequestRouter(View defaultController) {
		_defaultController = defaultController;
		_list = new HashMap<View, String[]>();
	}

	public void add(View controller, String... paths) {
		_list.put(controller, paths);
	}
	
	public void handle(HttpServletRequest request, HttpServletResponse response, Connection connection) throws IOException {
		View controller = matchRoute(request);
		if (controller == null) {
			controller = _defaultController;
		}
		response.getWriter().write(controller.build(request, response, connection));
		response.setStatus(HttpServletResponse.SC_OK);
	}

	private View matchRoute(HttpServletRequest request) {
		View view = null;
		for (Entry<View, String[]> route : _list.entrySet()) {
			for (String path : route.getValue()) {
				Pattern p = Pattern.compile(path);
				if (p.matcher(request.getRequestURI()).matches()) {
					view = route.getKey();
					return view;
				}
			}
		}
		return null;
	}

}
