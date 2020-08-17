package com.retail.billing.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ProductTest {

	Product product;

	/**
	 * Discount not eligible as item belongs to Grocery type
	 */
	@Test
	public void testGroceryItem() {
		product = new Product("Milk", 2, 15, ProductCategory.GROCERY);
		assertEquals(new Double(30),
				new Double(product.getDiscountedPrice(product, 10.0)));
	}

	/**
	 * 10 percent discount is eligible for non grocery item. 500 - (10/100) =
	 * 450
	 */
	@Test
	public void testNonGroceryItem() {
		product = new Product("Mobile", 1, 500, ProductCategory.OTHERS);
		assertEquals(new Double(450),
				new Double(product.getDiscountedPrice(product, 10.0)));
	}

}
