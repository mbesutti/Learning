package com.mbesutti.refactorings.pullUpMethod.original;

import java.util.Date;

public class Customer {
	public Date lastBillDate;
	public double lastBillAmount;
	public void addBill(Date date, double chargeAmount) {
		lastBillDate = date;
		lastBillAmount = chargeAmount;
	}
}
