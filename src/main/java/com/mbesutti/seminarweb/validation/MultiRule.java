package com.mbesutti.seminarweb.validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiRule implements Rule{
	
	List<Rule> rules = new ArrayList<Rule>();

	@Override
	public boolean validate(String key, String value, Map<String, String> errors) {
		if (rules.isEmpty()){
			return true;
		}
		int i = 0;
		String errorsValues = "";
		boolean isValid = true;
		for (Rule rule : rules) {
			Map<String, String> ruleError = new HashMap<String,String>();
			boolean valid = rule.validate(key, value, ruleError);
			if (!valid && !ruleError.isEmpty()){
				String separator = i==0?"":", ";
				errorsValues += separator + ruleError.get(key);
				i++;
			}
			isValid &= valid;
		}
		if (errorsValues.isEmpty()){
			return isValid;
		}
		errors.put(key, errorsValues);
		return false;
	} 
	
	public MultiRule add(Rule rule){
		rules.add(rule);
		return this;
	}
	
}
