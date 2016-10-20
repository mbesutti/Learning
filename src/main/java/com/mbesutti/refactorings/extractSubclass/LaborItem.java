package com.mbesutti.refactorings.extractSubclass;

public class LaborItem extends JobItem {

	public LaborItem(int aUnitPrice, int aQuantity, boolean aIsLabor,	Employee aEmployee) {
		super(aUnitPrice, aQuantity, aIsLabor, null);
	}
	
	public Employee getEmployee() {
		return _employee;
	}

}
