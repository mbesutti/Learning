package com.mbesutti.refactorings.introduceNullObject;

public class PaymentHistory {
	int getWeeksDelinquentInLastYear(){
		return 3;
	}

	public static PaymentHistory newNull() {
		return new NullPaymentHistory();
	}
}
