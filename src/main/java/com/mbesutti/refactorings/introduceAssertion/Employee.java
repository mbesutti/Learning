package com.mbesutti.refactorings.introduceAssertion;

import org.junit.Assert;

public class Employee {
	private static final double NULL_EXPENSE = -1.0;
	private double _expenseLimit = NULL_EXPENSE;
	private Project _primaryProject;

	double getExpenseLimit() {
		// + assicuro che almeno una condizione sia vera
		// ? Assert.ON (p.219) ??
		Assert.assertTrue (_expenseLimit != NULL_EXPENSE || _primaryProject	!= null);
		// ----
		return (_expenseLimit != NULL_EXPENSE) ? _expenseLimit
				: _primaryProject.getMemberExpenseLimit();
	}

	boolean withinLimit(double expenseAmount) {
		return (expenseAmount <= getExpenseLimit());
	}
}
