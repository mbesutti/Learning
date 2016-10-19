package com.mbesutti.refactorings.preserveWholeObject;

public class Range {
	private final int _high;
	private final int _low;

	public Range(int low, int high) {
		_low = low;
		_high = high;
	}

	public int getHigh() {
		return _high;
	}

	public int getLow() {
		return _low;
	}

	boolean isWithin(HeatingPlan otherRange) {
		return getLow() >= otherRange._planRange.getLow() && getHigh() <= otherRange._planRange.getHigh();
	}
}