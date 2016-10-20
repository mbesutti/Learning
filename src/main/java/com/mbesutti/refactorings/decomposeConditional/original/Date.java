package com.mbesutti.refactorings.decomposeConditional.original;

public class Date {
	private final int _date;
	public Date(int date) {
		_date = date;
	}
	public boolean before (int date) {
		return _date<date;
	}
	public boolean after (int date) {
		return _date>date;
	}
}