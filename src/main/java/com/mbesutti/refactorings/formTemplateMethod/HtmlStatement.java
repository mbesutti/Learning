package com.mbesutti.refactorings.formTemplateMethod;


public class HtmlStatement extends Statement {

	@Override
	String footer(Customer customer) {
		return "<P>You owe <EM>" + String.valueOf(customer.getTotalCharge())
				+ "</EM><P>\n"
				+ "On this rental you earned <EM>"
				+ String.valueOf(customer.getTotalFrequentRenterPoints())
				+ "</EM> frequent renter points<P>";
	}

	@Override
	String eachRentalString(Object each) {
		return "each";
	}

	@Override
	String header(Customer customer) {
		return "<H1>Rentals for <EM>" + customer.getName() + "</EM></H1><P>\n";
	}

}
