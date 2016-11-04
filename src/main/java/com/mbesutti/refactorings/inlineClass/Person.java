package com.mbesutti.refactorings.inlineClass;

public class Person {
	public String getName() {
		return _name;
	}

	public String getTelephoneNumber() {
		return _officeTelephone.getTelephoneNumber();
	}

	TelephoneNumber getOfficeTelephone() {
		return _officeTelephone;
	}

	String getAreaCode() {
		return _officeTelephone.getAreaCode();
	}

	void setAreaCode(String arg) {
		_officeTelephone.setAreaCode(arg);
	}

	String getNumber() {
		return _officeTelephone.getNumber();
	}

	void setNumber(String arg) {
		_officeTelephone.setNumber(arg);
	}

	private String _name;
	private TelephoneNumber _officeTelephone = new TelephoneNumber();
}
