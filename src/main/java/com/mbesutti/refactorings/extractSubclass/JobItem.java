package com.mbesutti.refactorings.extractSubclass;

public class JobItem {
	public JobItem(int unitPrice, int quantity, boolean isLabor,	Employee employee) {
		_unitPrice = unitPrice;
		_quantity = quantity;
		_isLabor = isLabor;
		_employee = employee;
	}

	public JobItem(int unitPrice, int quantity, boolean isLabor) {
		this(unitPrice, quantity, isLabor, null);
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

	private final int _unitPrice;
	private final int _quantity;
	protected Employee _employee;
	private final boolean _isLabor;
}