package com.mbesutti.refactorings.introduceNullObject;

public class NullCustomer extends Customer {
	public boolean isNull(){
		return true;
	}
	
	public String getName(){
		return "occupant";
	}
	
	public PaymentHistory getHistory(){
		return PaymentHistory.newNull();
	}
}
