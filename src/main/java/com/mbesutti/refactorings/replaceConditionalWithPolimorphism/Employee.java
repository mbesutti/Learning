package com.mbesutti.refactorings.replaceConditionalWithPolimorphism;

public class Employee {
	private static final int _commission = 1;
	private static final int _bonus = 5;
	private static final int _monthlySalary = 1000;
	int payAmount() {
		switch (getType()) {
		case EmployeeType.ENGINEER:
			return _monthlySalary;
		case EmployeeType.SALESMAN:
			return _monthlySalary + _commission;
		case EmployeeType.MANAGER:
			return _monthlySalary + _bonus;
		default:
			throw new RuntimeException("Incorrect Employee");
		}
	}

	int getType() {
		return _type.getTypeCode();
	}

	private EmployeeType _type;
}
