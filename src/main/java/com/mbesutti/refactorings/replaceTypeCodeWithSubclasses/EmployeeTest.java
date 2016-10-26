package com.mbesutti.refactorings.replaceTypeCodeWithSubclasses;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmployeeTest {
	@Test
	public void testName() {
		Employee employee = Employee.create(Employee.MANAGER);
		assertEquals(Employee.MANAGER, employee.getType());
	}
}
