package com.mbesutti.refactorings.replaceDelegationWithInheritance;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EmployeeTest {
	@Test
	public void emp() {
		Employee emp = new Employee();
		emp.setName("first last");
		assertEquals("Employee: last", emp.toString());
	}
}
