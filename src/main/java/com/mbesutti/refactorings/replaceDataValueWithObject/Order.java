package com.mbesutti.refactorings.replaceDataValueWithObject;

import java.util.List;

public class Order {
    public Order (Customer customer) {
        _customer = customer;
    }
    public Customer getCustomer() {
        return _customer;
    }
    public void setCustomer(Customer customer) {
        _customer = customer;
    }
	public static int numberOfOrdersFor(List<Order> orders, Customer customer) {
		int result = 0;
		for (Order order : orders) {
			if (order.getCustomer().getName().equals(customer.getName()))
				result++;
		}
		return result;
	}
    private Customer _customer;
}
