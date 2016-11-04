package com.mbesutti.refactorings.introduceNullObject;

public class Customer {
	private BillingPlan _billingPlan;
	public String getName() {return "pippo";}
    public BillingPlan getPlan() {return _billingPlan;}
    public PaymentHistory getHistory() {return new PaymentHistory();}
    public boolean isNull(){return false;}
    
    static Customer newNull(){
    	return new NullCustomer();
    }
	public void setPlan(BillingPlan plan) {
		_billingPlan = plan;
	}
}
