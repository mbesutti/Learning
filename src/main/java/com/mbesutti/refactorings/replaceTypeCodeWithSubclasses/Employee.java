package com.mbesutti.refactorings.replaceTypeCodeWithSubclasses;

public class Employee {
	private final int _type;
	static final int ENGINEER = 0;
	static final int SALESMAN = 1;
	static final int MANAGER = 2;

	Employee(int type) {
		_type = type;
	}

	int getType() {
		return _type;
	}
}
