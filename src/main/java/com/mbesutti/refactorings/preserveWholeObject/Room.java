package com.mbesutti.refactorings.preserveWholeObject;

public class Room {
	boolean withinPlan(HeatingPlan plan) {
		return daysTemperatureRange().isWithin(plan);
	}

	private Range daysTemperatureRange() {
		return new Range(5, 10);
	}
}