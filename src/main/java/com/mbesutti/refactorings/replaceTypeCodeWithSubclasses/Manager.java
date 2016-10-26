package com.mbesutti.refactorings.replaceTypeCodeWithSubclasses;

public class Manager extends Employee {

	public int getType() {
		return Employee.MANAGER;
	}
	
}
