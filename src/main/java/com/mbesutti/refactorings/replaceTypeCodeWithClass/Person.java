package com.mbesutti.refactorings.replaceTypeCodeWithClass;

public class Person {
	private BloodGroup _bloodGroup;

	public Person(BloodGroup bloodGroup) {
		_bloodGroup = bloodGroup;
	}

	public void setBloodGroup(BloodGroup group) {
		_bloodGroup = group;
	}

	public BloodGroup getBloodGroup() {
		return _bloodGroup;
	}
}
