package com.mbesutti.seminarweb.validation;

import java.util.Map;

public class MaxLengthRule implements Rule {
	
	private final int _length;

	public MaxLengthRule(int length) {
		_length = length;
	}

	@Override
	public boolean validate(String key, String value, Map<String, String> errors) {
		if (value.length()<=_length){
			return true;
		}
		
		errors.put(key, "Value cannot have more than " + _length + " characters");
		return false;
	}

}
