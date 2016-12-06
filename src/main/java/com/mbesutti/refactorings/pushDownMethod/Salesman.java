package com.mbesutti.refactorings.pushDownMethod;

public class Salesman extends Employee {
	// this method is only used here
	public void getQuota(){
		
	}

	public void getTotal(){
		getQuota();
	}
}
