package com.mbesutti.refactorings.replaceTypeCodeWithStateStrategy;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmployeeTest {
	@Test
	public void managerSalary() {
		Employee employee = new Employee(2);
		assertEquals(2500, employee.payAmount());
	}
}
