package com.mbesutti.refactorings.preserveWholeObject.original;


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
	
}
