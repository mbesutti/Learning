package com.mbesutti.refactorings.replaceInheritanceWithDelegation;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyStackTest {
	@Test
	public void test() {
		MyStack stack = new MyStack();
		stack.push(123);
		assertEquals(1, stack.size());
		assertFalse(stack.isEmpty());
		assertEquals(123, stack.pop());
	}
}
