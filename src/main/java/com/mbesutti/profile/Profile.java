package com.mbesutti.profile;

public class Profile {

	public int sumFromZeroTo(int limit) {
		SumAccumulator sumAccumulator = new SumAccumulator();
		for (int value = 0; value <= limit; value++) {
			sumAccumulator.add(value);
		}
		return sumAccumulator.total();
	}
}
