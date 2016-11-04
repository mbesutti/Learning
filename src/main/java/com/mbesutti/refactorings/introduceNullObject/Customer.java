package com.mbesutti.refactorings.introduceNullObject;

public class Customer {
	public String getName() {return "pippo";}
    public BillingPlan getPlan() {return new BillingPlan();}
    public PaymentHistory getHistory() {return new PaymentHistory();}
}
