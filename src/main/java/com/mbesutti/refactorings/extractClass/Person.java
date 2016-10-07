package com.mbesutti.refactorings.extractClass;

public class Person {
	public String getName() {
		return _name;
	}

	public String getTelephoneNumber() {
		return ("(" + getOfficeAreaCode() + ") " + _officeNumber);
	}

	String getOfficeAreaCode() {
		return _officeTelephone.getAreaCode();
	}

	void setOfficeAreaCode(String arg) {
		_officeTelephone.setAreaCode(arg);
	}

	String getOfficeNumber() {
		return _officeNumber;
	}

	void setOfficeNumber(String arg) {
		_officeNumber = arg;
	}

	private String _name;
	private String _officeAreaCode;
	private String _officeNumber;
	private final TelephoneNumber _officeTelephone = new TelephoneNumber();
}
