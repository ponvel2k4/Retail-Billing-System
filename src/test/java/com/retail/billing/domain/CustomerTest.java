/**
 * 
 */
package com.retail.billing.domain;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import com.retail.billing.domain.Customer;

/**
 * @author ponvel
 *
 */
public class CustomerTest {

	Customer customer;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		customer = new Customer(CustomerType.CUSTOMER_FOR_ATLST_2YRS, "Peter",
				LocalDateTime.of(2020, 8, 17, 10, 05));
	}

	/**
	 * Not a customer from last two years
	 */
	@Test
	public void testCustomerIsNew() {
		customer.setJoinedDate(LocalDateTime.of(2019, 2, 17, 11, 05));
		assertEquals(false, customer.isEligibleForDiscount());
	}

	/**
	 * Customer for more than two years
	 */

	@Test
	public void testCustomerForLong() {
		customer.setJoinedDate(LocalDateTime.of(2015, 2, 17, 11, 05));
		assertEquals(customer.isEligibleForDiscount(), true);
	}
}
