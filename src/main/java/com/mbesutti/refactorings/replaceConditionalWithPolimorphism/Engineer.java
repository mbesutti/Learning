package com.mbesutti.refactorings.replaceConditionalWithPolimorphism;

class Engineer extends EmployeeType {
	int getTypeCode() {
		return ENGINEER;
	}

	int payAmount(Employee employee) {
		return employee.getMonthlySalary();
	}
}