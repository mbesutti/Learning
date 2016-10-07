package com.mbesutti.refactorings.formTemplateMethod;

import java.util.Enumeration;

public class TextStatement extends Statement {

	@Override
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
	
	@Override
	String header(Customer customer) {
		return "Rental Record for " + customer.getName() + "\n";
	}
	
	@Override
	String eachRentalString(Object each) {
		return "each";
	}

	@Override
	String footer(Customer customer) {
		return "Amount owed is " + String.valueOf(customer.getTotalCharge()) + "\n"
				+ "You earned " + String.valueOf(customer.getTotalFrequentRenterPoints())
				+ " frequent renter points";
	}

}
