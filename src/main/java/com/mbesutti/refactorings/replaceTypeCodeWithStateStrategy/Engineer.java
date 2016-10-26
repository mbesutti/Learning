package com.mbesutti.refactorings.replaceTypeCodeWithStateStrategy;

public class Engineer extends EmployeeType {

	@Override
	public int getTypeCode() {
		return Employee.ENGINEER;
	}
	
}
