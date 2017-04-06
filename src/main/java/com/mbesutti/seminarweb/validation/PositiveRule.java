package com.mbesutti.seminarweb.validation;

import java.util.Map;

public class PositiveRule implements Rule{

	@Override
	public boolean validate(String key, String value, Map<String, String> errors) {
		if (value == null || value.isEmpty()){
			addError(key, errors);
			return false;
		}
		
		int num;
		try{
			num = Integer.parseInt(value);
		}
		catch(Exception e){
			addError(key, errors);
			return false;
		}
		
		if (num>=0){
			return true;
		}
				
		addError(key, errors);
		return false;
	}

	private String addError(String key, Map<String, String> errors) {
		return errors.put(key, key + " must be a positive number");
	}

}
