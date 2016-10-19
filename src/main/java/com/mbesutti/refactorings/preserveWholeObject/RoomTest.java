package com.mbesutti.refactorings.preserveWholeObject;

import static org.junit.Assert.*;

import org.junit.Test;

public class RoomTest {
	@Test
	public void range() {
		Room room = new Room();
		boolean withinPlan = room.withinPlan(new HeatingPlan(new Range(5, 10)));
		assertTrue(withinPlan);
	}
	
	@Test
	public void outOfRange() {
		Room room = new Room();
		boolean withinPlan = room.withinPlan(new HeatingPlan(new Range(1, 4)));
		assertFalse(withinPlan);
	}
}