package com.mbesutti.refactorings.replaceTempWithQuery;

import junit.framework.Assert;

import org.junit.Test;

//import com.mbesutti.refactorings.replaceTempWithQuery.original.Product;

public class ProductTest {
	@Test
	public void price() {
		Assert.assertEquals(5.88, new Product().getPrice());
	}
}
