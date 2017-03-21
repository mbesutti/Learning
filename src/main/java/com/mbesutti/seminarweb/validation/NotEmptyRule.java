package com.mbesutti.seminarweb.validation;

import java.util.Map;

public class NotEmptyRule implements Rule{

	@Override
	public boolean validate(String key, String value, Map<String, String> errors) {
		if (value != null && !value.isEmpty()){
			return true;
		}
		errors.put(key, "Provide a value for " + key);
		return false;
	}

}
