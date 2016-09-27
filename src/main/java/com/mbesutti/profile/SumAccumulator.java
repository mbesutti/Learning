package com.mbesutti.profile;

public class SumAccumulator {
	private int sum;
	
	public SumAccumulator() {
		wait50ms();
	}
	
	public SumAccumulator add(int value) {
		sum += value;
		return this;
	}
	
	public int total() {
		return sum;
	}

	private void wait50ms() {
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
