package com.mbesutti.refactorings.replaceTypeCodeWithSubclasses;

public class Engineer extends Employee {

	public int getType() {
		return Employee.ENGINEER;
	}
	
}
