package com.mbesutti.refactorings.replaceTypeCodeWithStateStrategy;

public class Manager extends EmployeeType {

	@Override
	public int getTypeCode() {
		return Employee.MANAGER;
	}
	
}
