package com.mbesutti.seminarweb.validation;

import java.util.Map;

public class PositiveRule {

	private final String _key;
	private final Map<String, String> _errors;

	public PositiveRule(String key, Map<String, String> errors) {
		_key = key;
		_errors = errors;
	}

	public boolean validate(String value) {
		if (value == null || value.isEmpty()){
			return false;
		}
		
		if (Integer.parseInt(value)>0){
			return true;
		}
				
		_errors.put(_key, _key + " must be positive");
		return false;
	}

}
