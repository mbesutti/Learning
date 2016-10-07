package com.mbesutti.refactorings.pullUpMethod;

import java.util.Date;

public abstract class Customer {
	public Date lastBillDate;
	public double lastBillAmount;
	
	public void addBill(Date date, double chargeAmount) {
		lastBillDate = date;
		lastBillAmount = chargeAmount;
	}
	public void createBill(Date date) {	
		double chargeAmount = chargeFor (lastBillDate, date);
	    addBill (date, chargeAmount);
	}
	public abstract double chargeFor(Date start, Date end);
}
