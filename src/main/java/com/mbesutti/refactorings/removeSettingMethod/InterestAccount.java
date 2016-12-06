package com.mbesutti.refactorings.removeSettingMethod;

public class InterestAccount extends Account {
	private double _interestRate;

	InterestAccount(String id, double rate) {
		super(id);
		_interestRate = rate;
	}
}
