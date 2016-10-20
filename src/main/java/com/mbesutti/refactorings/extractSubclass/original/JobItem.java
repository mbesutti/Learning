package com.mbesutti.refactorings.extractSubclass.original;

import com.mbesutti.refactorings.extractSubclass.Employee;

public class JobItem {
	public JobItem(int unitPrice, int quantity, boolean isLabor,	Employee employee) {
		_unitPrice = unitPrice;
		_quantity = quantity;
		_isLabor = isLabor;
		_employee = employee;
	}

	public int getTotalPrice() {
		return getUnitPrice() * _quantity;
	}

	public int getUnitPrice() {
		return _isLabor ? _employee.getRate() : _unitPrice;
	}

	public int getQuantity() {
		return _quantity;
	}

	public Employee getEmployee() {
		return _employee;
	}

	private final int _unitPrice;
	private final int _quantity;
	private final Employee _employee;
	private final boolean _isLabor;
}