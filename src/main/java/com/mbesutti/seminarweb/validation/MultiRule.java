package com.mbesutti.seminarweb.validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiRule implements Rule{
	
	List<Rule> rules = new ArrayList<>();

	@Override
	public boolean validate(String key, String value, Map<String, String> errors) {
		Map<String, String> ruleError = new HashMap<>();
		int i = 0;
		String errorsValues = "";
		for (Rule rule : rules) {
			boolean valid = rule.validate(key, value, ruleError);
			if (!valid){
				String separator = i==0?"":", ";
				errorsValues += separator + ruleError.get(key);
				i++;
			}
		}
		if (errorsValues.isEmpty()){
			return true;
		}
		errors.put(key, errorsValues);
		return false;
	} 
	
	public MultiRule add(Rule rule){
		rules.add(rule);
		return this;
	}
	
}
