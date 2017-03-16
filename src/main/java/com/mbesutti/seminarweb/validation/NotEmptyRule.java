package com.mbesutti.seminarweb.validation;

import java.util.Map;

public class NotEmptyRule {

	private final String _key;
	private final Map<String, String> _errors;

	public NotEmptyRule(String key, Map<String, String> errors) {
		_key = key;
		_errors = errors;
	}

	public boolean validate(String value) {
		if (value != null && !value.isEmpty()){
			return true;
		}
		_errors.put(_key, "Provide a valid " + _key + "!");
		return false;
	}

}
