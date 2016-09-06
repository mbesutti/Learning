package com.mbesutti.refactoring;

public class Main {
	public static void main(String[] args) {
		Customer matteo = new Customer("matteo");
		matteo.addRental(new Rental(new Movie("a movie", 20), 5));
		String statement = matteo.statement();
		System.out.println(statement);
	}
}
