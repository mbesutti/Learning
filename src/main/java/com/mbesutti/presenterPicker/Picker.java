package com.mbesutti.presenterPicker;

import java.util.List;
import java.util.Random;

public class Picker {
	public static String pickFrom(List<String> aPresenters) {
		Random random = new Random();
		return aPresenters.get(random.nextInt(aPresenters.size()));
	}
}
