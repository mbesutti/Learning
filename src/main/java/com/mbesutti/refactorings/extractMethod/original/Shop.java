package com.mbesutti.refactorings.extractMethod.original;

import java.util.Enumeration;
import java.util.Vector;

public class Shop {
	private final Vector<Order> _orders;
	private final String _name;
	
	public Shop() {
		_name = "Bike shop";
		_orders = new Vector<Order>();
	}

	public void printOwing() {
	       Enumeration<Order> e = _orders.elements();
	       double outstanding = 0.0;
	       // print banner
	       System.out.println ("**************************");
	       System.out.println ("***** Customer Owes ******");
	       System.out.println ("**************************");
	       // calculate outstanding
	       while (e.hasMoreElements()) {
	           Order each = e.nextElement();
	           outstanding += each.getAmount();
	       }
	       //print details
	       System.out.println ("name:" + _name);
	       System.out.println ("amount" + outstanding);
	   }
}
