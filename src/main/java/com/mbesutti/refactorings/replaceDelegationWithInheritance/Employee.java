package com.mbesutti.refactorings.replaceDelegationWithInheritance;

public class Employee extends Person {
	// -
//	Person _person = new Person();
//
//	public String getName() {
//		return _person.getName();
//	}
//
//	public void setName(String name) {
//		_person.setName(name);
//	}

	public String toString() {
		return "Employee: " + getLastName();
//		return "Employee: " + _person.getLastName();
	}
}
