package com.mbesutti.refactorings.replaceParameterWithExplicitMethods;

public class Engineer extends Employee {

	@Override
	public int getTypeCode() {
		return EmployeeFactory.ENGINEER;
	}
	
}
