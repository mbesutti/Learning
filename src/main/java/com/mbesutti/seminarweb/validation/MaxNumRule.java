package com.mbesutti.seminarweb.validation;

import java.util.Map;

public class MaxNumRule implements Rule {
	private final int _max;

	public MaxNumRule(int max) {
		_max = max;
	}

	@Override
	public boolean validate(String key, String value, Map<String, String> errors) {
		if (value == null || value.isEmpty()){
			return false;
		}
		
		int num;
		try{
			num = Integer.parseInt(value);
		}
		catch(Exception e){
			return false;
		}

		if (num<=_max){
			return true;
		}
		
		errors.put(key, "Value cannot be higher than " + _max);
		return false;
	}
}
