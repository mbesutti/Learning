package com.mbesutti.refactorings.replaceDataValueWithObject;

import java.util.List;

public class Order {
    public Order (String customer) {
        _customer = customer;
    }
    public String getCustomerName() {
        return _customer;
    }
    public void setCustomer(String arg) {
        _customer = arg;
    }
	public static int numberOfOrdersFor(List<Order> orders, String customer) {
		int result = 0;
		for (Order order : orders) {
			if (order.getCustomerName().equals(customer))
				result++;
		}
		return result;
	}
    private String _customer;
}
