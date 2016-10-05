package com.mbesutti.movieRental.statement;

import java.util.Enumeration;

import com.mbesutti.movieRental.Customer;
import com.mbesutti.movieRental.Rental;

public abstract class Statement {
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
	abstract String header(Customer aCustomer);
	abstract String eachRentalString(Rental aEach);
	abstract String footer(Customer aCustomer);
}
