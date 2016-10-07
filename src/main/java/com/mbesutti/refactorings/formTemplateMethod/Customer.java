package com.mbesutti.refactorings.formTemplateMethod;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
	private final String _name;
	private final Vector _rentals = new Vector();

	public Customer(String name) {
		_name = name;
	};

	public String getName() {
		return _name;
	};

	public String statement() {
		return new TextStatement().value(this);
	}

	public String htmlStatement() {
		return new HtmlStatement().value(this);
	}

	public double getTotalCharge() {
		double result = 0;
		return result;
	}

	public int getTotalFrequentRenterPoints() {
		int result = 0;
		return result;
	}

	public Enumeration getRentals() {
		return _rentals.elements();
	}
}