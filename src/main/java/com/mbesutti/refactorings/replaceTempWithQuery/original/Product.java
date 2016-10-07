package com.mbesutti.refactorings.replaceTempWithQuery.original;

public class Product {
    private final int _quantity = 2;
	private final int _itemPrice = 3;

	public double getPrice() {
        int basePrice = _quantity * _itemPrice;
        double discountFactor;
        if (basePrice > 1000) discountFactor = 0.95;
        else discountFactor = 0.98;
        return basePrice * discountFactor;
    }
}
