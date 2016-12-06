package com.mbesutti.refactorings.introduceForeignMethod;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class BillingPeriodTest {
	@Test
	public void before() throws Exception {
		Date start = BillingPeriod.getNewStart(new Date(2016,12,5));
		assertEquals(new Date(2016,12,6), start);
	}
}
