package com.mbesutti.refactoring.tests;

import junit.framework.Assert;

import org.junit.Test;

import com.mbesutti.movieRental.ChildrensPrice;
import com.mbesutti.movieRental.Customer;
import com.mbesutti.movieRental.Movie;
import com.mbesutti.movieRental.NewReleasePrice;
import com.mbesutti.movieRental.RegularPrice;
import com.mbesutti.movieRental.Rental;

public class RentalTests {
	@Test
	public void oneRegularRental() {
		Customer matteo = new Customer("matteo");
		Movie aMovie = new Movie("a movie", new RegularPrice());
		Rental rental = new Rental(aMovie, 5);
		matteo.addRental(rental);
		String statement = matteo.statement();
		Assert.assertEquals("Rental Record for matteo\n"
									+"\ta movie	6.5\n"
									+"Amount owed is 6.5\n"
									+"You earned 1 frequent renter points", statement);
	}
	
	@Test
	public void oneNewReleaseRental() {
		Customer matteo = new Customer("matteo");
		Movie aMovie = new Movie("a movie", new NewReleasePrice());
		Rental rental = new Rental(aMovie, 5);
		matteo.addRental(rental);
		String statement = matteo.statement();
		Assert.assertEquals("Rental Record for matteo\n"
									+"\ta movie	15.0\n"
									+"Amount owed is 15.0\n"
									+"You earned 2 frequent renter points", statement);
	}
	
	@Test
	public void oneChildrenRental() {
		Customer matteo = new Customer("matteo");
		Movie aMovie = new Movie("a movie", new ChildrensPrice());
		Rental rental = new Rental(aMovie, 5);
		matteo.addRental(rental);
		String statement = matteo.statement();
		Assert.assertEquals("Rental Record for matteo\n"
									+"\ta movie	4.5\n"
									+"Amount owed is 4.5\n"
									+"You earned 1 frequent renter points", statement);
	}
}
