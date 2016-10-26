package com.mbesutti.refactorings.replaceTypeCodeWithClass;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersonTest {
	@Test
	public void testName() {
		Person person = new Person(BloodGroup.AB);
		assertEquals(BloodGroup.AB, person.getBloodGroup());
	}
}
