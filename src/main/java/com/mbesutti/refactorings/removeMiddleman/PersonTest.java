package com.mbesutti.refactorings.removeMiddleman;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PersonTest {
	@Test
	public void john() {
		Person john = new Person();
		john.setName("john");
		Person manager = new Person();
		manager.setName("m1");
		john.setDepartment(new Department(manager));
//		Person johnManager = john.getManager();
//		assertEquals("m1", johnManager.getName());
		Person johnManager = john.getDepartment().getManager();
		assertEquals("m1", johnManager.getName());
	}
}
