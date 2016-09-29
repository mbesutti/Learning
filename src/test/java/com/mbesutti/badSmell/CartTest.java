package com.mbesutti.badSmell;

import static org.junit.Assert.*;

import org.junit.Test;

public class CartTest {
	
	@Test
	public void total() throws Exception {
		Cart cart = new Cart();
		cart.addProduct(new Product(0, 1, 30));
		cart.addProduct(new Product(1, 2, 50));
		int total = cart.total();
		assertEquals(80, total);
	}
	
	@Test
	public void moreThanOneQuantity() throws Exception {
		Cart cart = new Cart();
		cart.addProduct(new Product(1, 1, 30));
		cart.addProduct(new Product(1, 2, 50));
		int total = cart.total();
		assertEquals(80, total);
	}
}
