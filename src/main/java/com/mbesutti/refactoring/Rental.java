package com.mbesutti.refactoring;

public class Rental {
	private final Movie _movie;
	private final int _daysRented;

	public Rental(Movie movie, int daysRented) {
		_movie = movie;
		_daysRented = daysRented;
	}

	public int getDaysRented() {
		return _daysRented;
	}

	public Movie getMovie() {
		return _movie;
	}

	int getFrequentRenterPoints() {
		return _movie.getFrequentRenterPoints(_daysRented);
	}
	
	public double getCharge() {
		return _movie.getCharge(_daysRented);
	}
}
