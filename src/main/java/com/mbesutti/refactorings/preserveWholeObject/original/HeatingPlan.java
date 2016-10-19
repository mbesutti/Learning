package com.mbesutti.refactorings.preserveWholeObject.original;

public class HeatingPlan {
	private final Range _range;
	
	public HeatingPlan(Range range) {
		_range = range;
	}

	boolean withinRange(int low, int high) {
		return (low >= _range.getLow() && high <= _range.getHigh());
	}
}
