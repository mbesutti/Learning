package com.mbesutti.refactorings.extractSubclass.original;

public class Employee {

	public Employee(int rate) {
		_rate = rate;
	}

	public int getRate() {
		return _rate;
	}

	private final int _rate;
}
