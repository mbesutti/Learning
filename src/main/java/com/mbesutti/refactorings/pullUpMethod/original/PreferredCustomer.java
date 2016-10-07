package com.mbesutti.refactorings.pullUpMethod.original;

import java.util.Date;

public class PreferredCustomer extends Customer {
	public void createBill(Date date) {	
		double chargeAmount = chargeFor (lastBillDate, date);
	    addBill (date, chargeAmount);
	}
	public double chargeFor(Date start, Date end) {
		return 3.0;
	}
}
