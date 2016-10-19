package com.mbesutti.refactorings.replaceMethodWithMethodObject;

public class Gamma {
	final Account _account;
	int _inputVal;
	int _quantity;
	int _yearToDate;
	
	public Gamma(Account account, int inputVal, int quantity, int yearToDate) {
		_account = account;
		_inputVal = inputVal;
		_quantity = quantity;
		_yearToDate = yearToDate;
	}
	
	public int compute() {
		int importantValue1 = importantValue1();
		int importantValue2 = importantValue2();
		if ((_yearToDate - importantValue1) > 100)
			importantValue2 -= 20;
		int importantValue3 = importantValue2 * 7;
		// and so on.
		return importantValue3 - 2 * importantValue1;
	}

	private int importantValue2() {
		return (_inputVal * _yearToDate) + 100;
	}

	private int importantValue1() {
		return (_inputVal * _quantity) + _account.delta();
	}
}