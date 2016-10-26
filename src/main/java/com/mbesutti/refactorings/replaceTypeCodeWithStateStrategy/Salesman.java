package com.mbesutti.refactorings.replaceTypeCodeWithStateStrategy;

public class Salesman extends EmployeeType {

	@Override
	public int getTypeCode() {
		return Employee.SALESMAN;
	}
	
}
