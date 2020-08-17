package com.retail.billing.service;

import java.util.List;

import com.retail.billing.domain.Customer;
import com.retail.billing.domain.Product;

/**
 * 
 * @author ponvel
 *
 */
public interface IBillDiscount {
	double calculateTotalPayableAmount(Customer customer, List<Product> products);
}
