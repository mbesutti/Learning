package com.mbesutti.refactorings.replaceMethodWithMethodObject;

import static org.junit.Assert.*;

import org.junit.Test;

public class AccountTest {
	@Test
	public void gamma() {
		assertEquals(717, new Account().gamma(1, 2, 3));
	}
}