package com.mbesutti.seminarweb.validation;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class ValidationsTest {
	
	private Map<String, String> _errors;
	
	@Before
	public void before(){
		_errors = new HashMap<String,String>();
	}
	
	@Test
	public void dateValid() {
		String key = "date";
		boolean valid = new DateFormatRule().validate(key, "12.12.2017", _errors);
		
		assertTrue(valid);
		assertEquals(null, _errors.get(key));
	}
	
	@Test
	public void dateInvalid() {
		String key = "date";
		boolean valid = new DateFormatRule().validate(key, "2012.12.17", _errors);
		
		assertFalse(valid);
		assertEquals(key + " has wrong format", _errors.get(key));
	}
	
	@Test
	public void lengthValid() {
		String key = "short";
		boolean valid = new MaxLengthRule(2).validate(key, "ab", _errors);
		
		assertTrue(valid);
		assertEquals(null, _errors.get(key));
	}
	
	@Test
	public void lengthInvalid() {
		String key = "long";
		boolean valid = new MaxLengthRule(2).validate(key, "abc", _errors);
		
		assertFalse(valid);
		assertEquals("Value cannot have more than 2 characters", _errors.get(key));
	}
	
	@Test
	public void maxNumValid() {
		String key = "valid";
		boolean valid = new MaxNumRule(15).validate(key, "15", _errors);
		
		assertTrue(valid);
		assertEquals(null, _errors.get(key));
	}
	
	@Test
	public void maxNumInvalid() {
		String key = "invalid";
		int max = 15;
		boolean valid = new MaxNumRule(max).validate(key, "16", _errors);
		
		assertFalse(valid);
		assertEquals("Value cannot be higher than "+max, _errors.get(key));
	}
	
	@Test
	public void notEmptyValid() {
		String key = "field";
		boolean valid = new NotEmptyRule().validate(key, "ciao", _errors);
		
		assertTrue(valid);
		assertEquals(null, _errors.get(key));
	}
	
	@Test
	public void notEmptyInvalid() {
		String key = "field";
		boolean valid = new NotEmptyRule().validate(key, "", _errors);
		
		assertFalse(valid);
		assertEquals("Provide a value for "+key, _errors.get(key));
	}
	
	@Test
	public void positiveValid() {
		String key = "positive";
		boolean valid = new PositiveRule().validate(key, "0", _errors);
		
		assertTrue(valid);
		assertEquals(null, _errors.get(key));
	}
	
	@Test
	public void positiveInvalid() {
		String key = "field";
		boolean valid = new PositiveRule().validate(key, "-1", _errors);
		
		assertFalse(valid);
		assertEquals(key+" must be a positive number", _errors.get(key));
	}
	
	@Test
	public void multiRuleValid() {
		String key = "field";
		boolean valid = new MultiRule()
						.add(new NotEmptyRule())
				        .add(new PositiveRule())
				        .add(new MaxLengthRule(3))
				        .add(new MaxNumRule(999))
				.validate(key, "123", _errors);
		System.out.println(valid);
		assertTrue(valid);
		assertEquals(null, _errors.get(key));
	}
	
	@Test
	public void multiRuleOneInvalid() {
		String key = "field";
		boolean valid = new MultiRule().add(new NotEmptyRule())
				        .add(new PositiveRule())
				        .add(new MaxLengthRule(3))
				        .add(new MaxNumRule(999))
				.validate(key, "-12", _errors);
		
		assertFalse(valid);
		assertEquals(key+" must be a positive number", _errors.get(key));
	}
	
	@Test
	public void multiRuleMultipleInvalid() {
		String key = "field";
		boolean valid = new MultiRule().add(new NotEmptyRule())
				        .add(new PositiveRule())
				        .add(new MaxLengthRule(3))
				        .add(new MaxNumRule(999))
				.validate(key, "-124", _errors);
		
		assertFalse(valid);
		assertEquals(key+" must be a positive number, Value cannot have more than 3 characters", _errors.get(key));
	}
}
