package com.mbesutti.profile.before;

public class Calc {
	
	public Calc() {
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
	
	public int accumulate(int sum, int value) {
		return (sum += value);
	}
}