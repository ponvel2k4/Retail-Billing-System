package com.retail.billing.domain;

/**
 * 
 * @author ponvel
 *
 */
public enum CustomerType {

	EMPLOYEE(30), AFFILIATE(10), CUSTOMER_FOR_ATLST_2YRS(5);

	private double discountPercentage;

	CustomerType(double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public double getDiscountPercentage() {
		return discountPercentage;
	}

}
