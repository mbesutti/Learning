package com.mbesutti.refactorings.hideDelegate;

public class Department {
	private Person _manager;

	public Department(Person manager) {
		_manager = manager;
	}

	public Person getManager() {
		return _manager;
	}
}
