package com.mbesutti.refactorings.pullUpMethod;

import java.util.Date;

public class RegularCustomer extends Customer {
	@Override
	public double chargeFor(Date start, Date end) {
		return 2.0;
	}
}
