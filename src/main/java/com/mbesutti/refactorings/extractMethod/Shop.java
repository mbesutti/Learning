package com.mbesutti.refactorings.extractMethod;

import java.util.Enumeration;
import java.util.Vector;

import com.mbesutti.refactorings.extractMethod.original.Order;

public class Shop {
	private final Vector<Order> _orders;
	private final String _name;
	
	public Shop() {
		_name = "Bike shop";
		_orders = new Vector<Order>();
	}

	void printOwing() {
	       printBanner();
	       double outstanding = getOutstanding();
	       printDetails(outstanding);
	   }

	private double getOutstanding() {
		Enumeration<Order> e = _orders.elements();
		double result = 0.0;
		while (e.hasMoreElements()) {
			Order each = e.nextElement();
			result += each.getAmount();
		}
		return result;
	}

	private void printDetails(double outstanding) {
		System.out.println("name:" + _name);
		System.out.println("amount" + outstanding);
	}

	private void printBanner() {
		System.out.println("**************************");
		System.out.println("***** Customer Owes ******");
		System.out.println ("**************************");
	}
}
