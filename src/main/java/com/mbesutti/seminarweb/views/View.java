package com.mbesutti.seminarweb.views;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface View {
	String build(HttpServletRequest request, HttpServletResponse response, Connection connection);
}