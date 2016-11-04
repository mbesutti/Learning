package com.mbesutti.refactorings.introduceNullObject;

public class NullPaymentHistory extends PaymentHistory {
	int getWeeksDelinquentInLastYear(){
		return 0;
	}
}
