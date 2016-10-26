package com.mbesutti.refactorings.replaceDataValueWithObject;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class OrderTest {
	@Test
	public void testName() {
		List<Order> orders = new ArrayList<Order>();
		orders.add(new Order(new Customer("marco")));
		orders.add(new Order(new Customer("marco")));
		orders.add(new Order(new Customer("giulia")));
		assertEquals(2, Order.numberOfOrdersFor(orders, new Customer("marco")));
	}
}
