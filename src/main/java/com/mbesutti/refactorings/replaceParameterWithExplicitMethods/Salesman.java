package com.mbesutti.refactorings.replaceParameterWithExplicitMethods;

public class Salesman extends Employee {

	@Override
	public int getTypeCode() {
		return EmployeeFactory.SALESMAN;
	}
	
}
