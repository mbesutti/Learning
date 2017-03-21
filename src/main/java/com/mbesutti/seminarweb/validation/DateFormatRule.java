package com.mbesutti.seminarweb.validation;

import java.util.Map;

public class DateFormatRule implements Rule {

	@Override
	public boolean validate(String key, String value, Map<String, String> errors) {
		if (value.matches("\\d{2}.\\d{2}.\\d{4}")) {
		    return true;
		}
		
		errors.put(key, key + " has wrong format");
		return false;
		
	}

}
