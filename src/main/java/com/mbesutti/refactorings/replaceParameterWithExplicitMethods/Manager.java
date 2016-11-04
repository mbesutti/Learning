package com.mbesutti.refactorings.replaceParameterWithExplicitMethods;

public class Manager extends Employee {

	@Override
	public int getTypeCode() {
		return EmployeeFactory.MANAGER;
	}
	
}
