package com.mbesutti.refactorings.replaceArrayWithObject;

public class TeamStatistic {
	private final String _name;
	private final int _wins;
	
	public TeamStatistic() {
		_name = "Liverpool";
		_wins = 15;
	}
	
	public String getName() {
		return _name;
	}
	
	public int getWins() {
		return _wins;
	}
}
