package com.mbesutti.refactorings.formTemplateMethod;

import java.util.Enumeration;

public abstract class Statement {
	public String value(Customer customer) {
		Enumeration rentals = customer.getRentals();
		String result = header(customer);
		while (rentals.hasMoreElements()) {
			Object each = rentals.nextElement();
			result += eachRentalString(each);
		}
		result += footer(customer);
		return result;
	}
	abstract String header(Customer aCustomer);
	abstract String eachRentalString(Object aEach);
	abstract String footer(Customer aCustomer);
}
