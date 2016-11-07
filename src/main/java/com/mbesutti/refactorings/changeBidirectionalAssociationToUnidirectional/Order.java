package com.mbesutti.refactorings.changeBidirectionalAssociationToUnidirectional;

public class Order {
	private int _amount;
	
//	Customer getCustomer() {
//		return _customer;
//	}
//
//	void setCustomer(Customer arg) {
//		if (_customer != null)
//			_customer.friendOrders().remove(this);
//		_customer = arg;
//		if (_customer != null)
//			_customer.friendOrders().add(this);
//	}

	public int getAmount() {
		return _amount;
	}

	public void setAmount(int amount) {
		this._amount = amount;
	}

//	private Customer _customer;
}