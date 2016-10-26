package com.mbesutti.refactorings.replaceArrayWithObject;

import static org.junit.Assert.*;

import org.junit.Test;

public class TeamTest {
	@Test
	public void statistic() {
		TeamStatistic statistics = new TeamStatistic();
	    assertEquals("Liverpool", statistics.getName());
	    assertEquals(15, statistics.getWins());
	}
}
