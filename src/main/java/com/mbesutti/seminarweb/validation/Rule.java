package com.mbesutti.seminarweb.validation;

import java.util.Map;

public interface Rule {
	public boolean validate(String key, String value, Map<String, String> errors);
}
