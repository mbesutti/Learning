package com.mbesutti.refactoring.tests;

import junit.framework.Assert;

import org.junit.Test;

import com.mbesutti.refactoring.Customer;
import com.mbesutti.refactoring.Movie;
import com.mbesutti.refactoring.Rental;

public class RentalTests {
	@Test
	public void oneRental() {
		Customer matteo = new Customer("matteo");
		Movie aMovie = new Movie("a movie", Movie.REGULAR);
		Rental rental = new Rental(aMovie, 5);
		matteo.addRental(rental);
		String statement = matteo.statement();
		Assert.assertEquals("Rental Record for matteo\n"
									+"\ta movie	6.5\n"
									+"Amount owed is 6.5\n"
									+"You earned 1 frequent renter points", statement);
	}
}
