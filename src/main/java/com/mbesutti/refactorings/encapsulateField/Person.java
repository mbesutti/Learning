package com.mbesutti.refactorings.encapsulateField;

public class Person {
//	 public String name;
	 private String _name;

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		this._name = name;
	}
	 
	 
}
