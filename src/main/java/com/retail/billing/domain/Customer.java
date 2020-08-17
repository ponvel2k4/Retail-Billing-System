package com.retail.billing.domain;

import java.time.LocalDateTime;

/**
 * 
 * @author ponvel
 *
 */
public class Customer {

	private static final int CUSTOMER_FROM_TIME_PERIOD_IN_YRS = 2;

	private String customerName;

	private CustomerType customerType;

	private LocalDateTime joinedDate;

	public Customer(CustomerType customerType, String customerName,
			LocalDateTime joinedDate) {
		super();
		this.customerType = customerType;
		this.customerName = customerName;
		this.joinedDate = joinedDate;
	}

	public String getCustomerName() {
		return customerName;
	}

	public CustomerType getCustomerType() {
		return customerType;
	}

	public LocalDateTime getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(LocalDateTime joinedDate) {
		this.joinedDate = joinedDate;
	}

	/**
	 * Method to find if customer is eligible for discount
	 * 
	 * @return boolean
	 */
	public boolean isEligibleForDiscount() {
		LocalDateTime dateToCompare = LocalDateTime.now().minusYears(
				CUSTOMER_FROM_TIME_PERIOD_IN_YRS);
		return getJoinedDate().isBefore(dateToCompare)
				&& (CustomerType.CUSTOMER_FOR_ATLST_2YRS == customerType);
	}
}
