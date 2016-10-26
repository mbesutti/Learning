package com.mbesutti.refactorings.replaceTypeCodeWithClass;

public enum BloodGroup {
	O(0), A(1), B(2), AB(3);
	
	private final int group;
	BloodGroup(int group) { this.group = group; }
    public int getValue() { return group; }
}
