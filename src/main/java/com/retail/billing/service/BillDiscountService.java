package com.retail.billing.service;

import java.util.List;

import com.retail.billing.domain.Customer;
import com.retail.billing.domain.CustomerType;
import com.retail.billing.domain.Product;

/**
 * Service class to find the total payable amount for a bill
 * 
 * @author ponvel
 *
 */
public class BillDiscountService implements IBillDiscount {
	private static final int DISCOUNT_PER_HUNDRED = 5;

	/**
	 * calculates net payable amount based on type of customer and products
	 * chosen
	 */
	public double calculateTotalPayableAmount(Customer customer,
			List<Product> products) {
		double totalDiscountedPrice = 0;
		// Get the discount percentage for customer type
		double discountPercentage = getDiscountPercentageForCustomer(customer);
		for (Product product : products) {
			// Get the discounted price for all the products customer has chosen
			totalDiscountedPrice = totalDiscountedPrice
					+ product.getDiscountedPrice(product, discountPercentage);
		}

		// Returns the net payable amount after the discount if any
		return totalDiscountedPrice
				- getDiscountBasedOnTotalAmount(totalDiscountedPrice);
	}

	private double getDiscountPercentageForCustomer(Customer customer) {
		CustomerType customerType = customer.getCustomerType();
		if (customerType == CustomerType.AFFILIATE
				|| customerType == CustomerType.EMPLOYEE
				|| customer.isEligibleForDiscount()) {
			return customerType.getDiscountPercentage();
		}
		return 0;
	}

	private double getDiscountBasedOnTotalAmount(double totalDiscountedPrice) {
		return Math.floor(totalDiscountedPrice / 100) * DISCOUNT_PER_HUNDRED;
	}
}
