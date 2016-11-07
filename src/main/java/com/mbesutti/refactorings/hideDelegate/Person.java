package com.mbesutti.refactorings.hideDelegate;

public class Person {
	private Department _department;
	private String _name;
	
	public String getName(){
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public Department getDepartment() {
		return _department;
	}

	public void setDepartment(Department department) {
		_department = department;
	}
	
	// +
	public Person getManager(){
		return _department.getManager();
	}
}
