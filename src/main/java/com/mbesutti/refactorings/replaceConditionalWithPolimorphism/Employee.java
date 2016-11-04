package com.mbesutti.refactorings.replaceConditionalWithPolimorphism;

public class Employee {
	private static final int _commission = 1;
	private static final int _bonus = 5;
	private static final int _monthlySalary = 1000;

	int getType() {
		return _type.getTypeCode();
	}
	int getMonthlySalary(){
		return _monthlySalary;
	}
	int getBonus(){
		return _bonus;
	}
	int getCommission(){
		return _commission;
	}

	private EmployeeType _type;
}
