package com.mbesutti.refactorings.replaceTypeCodeWithStateStrategy;

public class Employee {
	private EmployeeType _type;
	private final int _monthlySalary = 2000;
	private final int _commission = 100;
	private final int _bonus = 500;
	static final int ENGINEER = 0;
	static final int SALESMAN = 1;
	static final int MANAGER = 2;

	Employee(int type) {
		setType(type);
	}
	
	public int getType() {
		return _type.getTypeCode();
	}

	void setType(int type) {
		switch (type) {
		case ENGINEER:
			_type = new Engineer();
			break;
		case SALESMAN:
			_type = new Salesman();
			break;
		case MANAGER:
			_type = new Manager();
			break;
		default:
			throw new IllegalArgumentException("Incorrect EmployeeCode");
		}
	}

	int payAmount() {
		switch (getType()) {
		case ENGINEER:
			return _monthlySalary;
		case SALESMAN:
			return _monthlySalary + _commission;
		case MANAGER:
			return _monthlySalary + _bonus;
		default:
			throw new RuntimeException("Incorrect Employee");
		}
	}
}
