package com.mbesutti.refactorings.decomposeConditional.original;

public class ChargeCalculator {
	private static final int SUMMER_START = 5;
	private static final int SUMMER_END = 10;
	private final int _winterRate = 2;
	private final int _summerRate = 1;
	private final int _winterServiceCharge = 3;

	public int charge(Date date, int quantity) {
		int charge;
		if (date.before(SUMMER_START) || date.after(SUMMER_END))
			charge = quantity * _winterRate + _winterServiceCharge;
		else
			charge = quantity * _summerRate;
		return charge;
	}
}
