package com.mbesutti.refactorings.pullUpMethod;

import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;

//import com.mbesutti.refactorings.pullUpMethod.original.PreferredCustomer;
//import com.mbesutti.refactorings.pullUpMethod.original.RegularCustomer;

public class CustomerTest {
	@Test
	public void preferred() {
		PreferredCustomer preferredCustomer = new PreferredCustomer();
		preferredCustomer.createBill(new Date());
		Assert.assertEquals(3.0, preferredCustomer.lastBillAmount);
	}
	
	@Test
	public void regular() {
		RegularCustomer preferredCustomer = new RegularCustomer();
		preferredCustomer.createBill(new Date());
		Assert.assertEquals(2.0, preferredCustomer.lastBillAmount);
	}
}
