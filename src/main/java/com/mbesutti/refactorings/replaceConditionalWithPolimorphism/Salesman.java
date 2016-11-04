package com.mbesutti.refactorings.replaceConditionalWithPolimorphism;

public class Salesman extends EmployeeType {

	@Override
	public int getTypeCode() {
		return EmployeeType.SALESMAN;
	}

	int payAmount(Employee employee) {
		return employee.getMonthlySalary() + employee.getCommission();
	}
	
}
