package com.mbesutti.seminarweb.validation;

import java.util.Map;

public class DateFormatRule {

	private final String _key;
	private final Map<String, String> _errors;

	public DateFormatRule(String key, Map<String, String> errors) {
		_key = key;
		_errors = errors;
	}

	public boolean validate(String value) {
		if (value.matches("\\d{2}.\\d{2}.\\d{4}")) {
		    return true;
		}
		
		_errors.put(_key, _key + " has wrong format");
		return false;
		
	}

}
