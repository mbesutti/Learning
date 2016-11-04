package com.mbesutti.refactorings.introduceNullObject;

public class BillingPlan {

	public static BillingPlan basic() {
		return new BillingPlan();
	}

}
