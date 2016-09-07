package com.mbesutti.refactoring;

public class RegularPrice extends Price {
	@Override
	public int getPriceCode() {
		return Movie.REGULAR;
	}
	@Override
	double getCharge(int daysRented) {
	         double result = 2;
	         if (daysRented > 2)
	             result += (daysRented - 2) * 1.5;
	         return result;
	}
}