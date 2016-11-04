package com.mbesutti.refactorings.replaceParameterWithExplicitMethods;

public class EmployeeFactory {
	static final int ENGINEER = 0;
	static final int SALESMAN = 1;
	static final int MANAGER = 2;

	static Employee create(int type) {
		switch (type) {
		case ENGINEER:
			return Employee.createEngineer();
		case SALESMAN:
			return Employee.createSalesman();
		case MANAGER:
			return Employee.createManager();
		default:
			throw new IllegalArgumentException("Incorrect type code value");
		}
	}
}
