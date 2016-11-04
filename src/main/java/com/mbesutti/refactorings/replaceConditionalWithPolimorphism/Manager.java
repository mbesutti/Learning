package com.mbesutti.refactorings.replaceConditionalWithPolimorphism;

public class Manager extends EmployeeType {

	@Override
	public int getTypeCode() {
		return EmployeeType.MANAGER;
	}

	int payAmount(Employee employee) {
		return employee.getMonthlySalary() + employee.getBonus();
	}
	
}
