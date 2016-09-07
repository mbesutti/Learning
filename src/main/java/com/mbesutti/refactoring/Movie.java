package com.mbesutti.refactoring;

public class Movie {
	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	private final String _title;
	private Price _priceCode;

	public Movie(String title, Price priceCode) {
		_title = title;
		_priceCode = priceCode;
	}

	public Price getPriceCode() {
		return _priceCode;
	}

	public void setPriceCode(Price arg) {
		_priceCode = arg;
	}

	public String getTitle() {
		return _title;
	}

	double getCharge(int daysRented) {
		return getPriceCode().getCharge(daysRented);
	}

	public int getFrequentRenterPoints(int daysRented) {
		return _priceCode.getFrequentRenterPoints(daysRented);
	};
}
