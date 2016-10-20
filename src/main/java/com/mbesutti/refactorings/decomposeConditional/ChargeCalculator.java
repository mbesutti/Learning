package com.mbesutti.refactorings.decomposeConditional;

public class ChargeCalculator {
	private static final int SUMMER_START = 5;
	private static final int SUMMER_END = 10;
	private final int _winterRate = 2;
	private final int _summerRate = 1;
	private final int _winterServiceCharge = 3;

	public int charge(Date date, int quantity) {
		return isSummer(date) ? summerCharge(quantity) : winterCharge(quantity);
	}

	private int summerCharge(int quantity) {
		return quantity * _summerRate;
	}

	private int winterCharge(int quantity) {
		return quantity * _winterRate + _winterServiceCharge;
	}

	private boolean isSummer(Date date) {
		return date.after(SUMMER_START) && date.before(SUMMER_END);
	}
}
