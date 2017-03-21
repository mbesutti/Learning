package com.mbesutti.seminarweb.validation;

import java.util.Map;

public class PositiveRule implements Rule{

	@Override
	public boolean validate(String key, String value, Map<String, String> errors) {
//		if (value == null || value.isEmpty()){
//			return false;
//		}
		
		if (value != null && !value.isEmpty() && Integer.parseInt(value)>=0){
			return true;
		}
				
		errors.put(key, key + " must be positive");
		return false;
	}

}
