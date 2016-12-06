package com.mbesutti.refactorings.introduceLocalExtension;

import java.util.Date;

public class MfDateWrap {
	private Date _original;

	public MfDateWrap(String dateString) {
		_original = new Date(dateString);
	};

	public MfDateWrap(Date arg) {
		_original = arg;
	}
	
	// no argument is needed, delegating methods called
    public Date nextDay() {
        return new Date (getYear(), getMonth(), getDate() + 1);
    }

	// metodi per delega
	public int getYear() {
		return _original.getYear();
	}

	public int getMonth() {
		return _original.getMonth();
	}

	public int getDate() {
		return _original.getDate();
	}

	public boolean equals(MfDateWrap arg) {
		return (toDate().equals(arg.toDate()));
	}
	// ---

	public Date toDate() {
		return _original;
	}
}
