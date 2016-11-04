package com.mbesutti.refactorings.introduceNullObject;

public class Site {
	Customer getCustomer() {
		return _customer;
	}

	private Customer _customer;

	public static void main(String[] args) {
		Site site = new Site();
		Customer customer = site.getCustomer();
		
		customer.setPlan(BillingPlan.special());

		String customerName = customer.getName();

		int weeksDelinquent = customer.getHistory().getWeeksDelinquentInLastYear();

	}
}
