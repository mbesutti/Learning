package com.mbesutti.refactorings.changeBidirectionalAssociationToUnidirectional;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CustomerTest {
	@Test
	public void cust() {
		Customer customer = new Customer();
		Order order = new Order();
		order.setAmount(123);
		customer.addOrder(order);
//		assertEquals(123, customer.friendOrders().get(0).getAmount());
		assertEquals(123, customer.getOrders().get(0).getAmount());
	}
}
