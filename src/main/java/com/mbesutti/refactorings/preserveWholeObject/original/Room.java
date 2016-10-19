package com.mbesutti.refactorings.preserveWholeObject.original;


public class Room {
	boolean withinPlan(HeatingPlan plan) {
		int low = daysTempRange().getLow();
		int high = daysTempRange().getHigh();
		return plan.withinRange(low, high);
	}

	private Range daysTempRange() {
		return new Range(5, 10);
	}
}
