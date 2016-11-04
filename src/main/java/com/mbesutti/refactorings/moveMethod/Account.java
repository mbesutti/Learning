package com.mbesutti.refactorings.moveMethod;

public class Account {
	double bankCharge() {
		double result = 4.5;
		if (_daysOverdrawn > 0)
			result += _type.overdraftCharge(_daysOverdrawn);
		return result;
	}

	AccountType _type;
	int _daysOverdrawn;
}
