package com.mbesutti.refactoring.statement;

import java.util.Enumeration;

import com.mbesutti.refactoring.Customer;
import com.mbesutti.refactoring.Rental;

public class TextStatement extends Statement {

	@Override
	public String value(Customer customer) {
		Enumeration<Rental> rentals = customer.getRentals();
		String result = header(customer);
		while (rentals.hasMoreElements()) {
			Rental each = rentals.nextElement();
			
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
	String eachRentalString(Rental each) {
		return "\t" + each.getMovie().getTitle() + "\t"
				+ String.valueOf(each.getCharge()) + "\n";
	}

	@Override
	String footer(Customer customer) {
		return "Amount owed is " + String.valueOf(customer.getTotalCharge()) + "\n"
				+ "You earned " + String.valueOf(customer.getTotalFrequentRenterPoints())
				+ " frequent renter points";
	}

}
