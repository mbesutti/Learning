package com.mbesutti.refactorings.moveFields;

public class Account {
	private AccountType _type;
	private double _interestRate;

	double interestForAmount_days(double amount, int days) {
		return _interestRate * amount * days / 365;
	}
}
