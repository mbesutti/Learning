package com.mbesutti.refactorings.replaceTypeCodeWithSubclasses;

public class Salesman extends Employee {

	public int getType() {
		return Employee.SALESMAN;
	}
	
}
