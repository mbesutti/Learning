package com.mbesutti.refactorings.introduceForeignMethod;

import java.util.Date;

public class BillingPeriod {
	public static Date getNewStart(Date previousEnd) {
		return nextDay(previousEnd);
	}

	public static Date nextDay(Date arg) {
		// foreign method, should be on date
		return new Date(arg.getYear(), arg.getMonth(), arg.getDate() + 1);
	}
}