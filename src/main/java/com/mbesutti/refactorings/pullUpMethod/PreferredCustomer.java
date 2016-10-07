package com.mbesutti.refactorings.pullUpMethod;

import java.util.Date;

public class PreferredCustomer extends Customer {
	@Override
	public double chargeFor(Date start, Date end) {
		return 3.0;
	}
}
