package com.mbesutti.refactorings.changeBidirectionalAssociationToUnidirectional;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	void addOrder(Order order) {
//		arg.setCustomer(this);
		_orders.add(order);
	}

	private List<Order> _orders = new ArrayList<Order>();

	public List<Order> getOrders() {
		/**
		 * should only be used by Order
		 */
		return _orders;
	}
//	public List<Order> friendOrders() {
//	/**
//	 * should only be used by Order
//	 */
//	return _orders;
//}
}