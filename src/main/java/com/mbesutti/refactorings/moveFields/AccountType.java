package com.mbesutti.refactorings.moveFields;

public class AccountType {

	private double _interestRate;

	public double getInterestRate() {
		return _interestRate;
	}

	private void setInterestRate(double _interestRate) {
		this._interestRate = _interestRate;
	}

}
