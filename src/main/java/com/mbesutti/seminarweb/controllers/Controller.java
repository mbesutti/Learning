package com.mbesutti.seminarweb.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	String build(HttpServletRequest aReq, HttpServletResponse aRes);
}
