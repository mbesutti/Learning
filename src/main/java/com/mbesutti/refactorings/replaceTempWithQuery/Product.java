package com.mbesutti.refactorings.replaceTempWithQuery;

public class Product {
    private final int _quantity = 2;
	private final int _itemPrice = 3;

	double getPrice() {
		return basePrice() * discountFactor();
	}

	private double discountFactor() {
		if (basePrice() > 1000)
			return 0.95;
		return 0.98;
	}

	private int basePrice() {
		return _quantity * _itemPrice;
	}
}
