package com.retail.billing.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.retail.billing.base.CustomerProductsBuilder;
import com.retail.billing.domain.Customer;
import com.retail.billing.domain.Product;

/**
 * Test class to test the bill discount service and find net payable amount
 * 
 * @author ponvel
 *
 */
public class BillDiscountServiceTest {

	BillDiscountService service;

	@Before
	public void setUp() throws Exception {
		service = new BillDiscountService();
	}

	/**
	 * Customer is an employee, and bought grocery products hence no discounts
	 * provided on total price Total bill is 60, Net payable is 60
	 */
	@Test
	public void testEmployeeGrocery() {
		Customer customer = CustomerProductsBuilder.buildEmployeeCust();
		List<Product> products = CustomerProductsBuilder.buildGroceryProducts();
		assertEquals(
				new Double(60),
				new Double(service.calculateTotalPayableAmount(customer,
						products)));
	}

	/**
	 * Customer is an affiliate, and bought grocery products hence no discounts
	 * provided on total price Total bill is 60, Net payable is 60
	 */
	@Test
	public void testAffiliateGrocery() {
		Customer customer = CustomerProductsBuilder.buildAffiliateCust();
		List<Product> products = CustomerProductsBuilder.buildGroceryProducts();
		assertEquals(
				new Double(60),
				new Double(service.calculateTotalPayableAmount(customer,
						products)));
	}

	/**
	 * Customer joined more than 2 years, and bought grocery products hence no
	 * discounts provided on total price Total bill is 60, Net payable is 60
	 */
	@Test
	public void testCustomerForMoreThan2YrsGrocery() {
		Customer customer = CustomerProductsBuilder.buildCustomerMoreThan2Yrs();
		List<Product> products = CustomerProductsBuilder.buildGroceryProducts();
		assertEquals(
				new Double(60),
				new Double(service.calculateTotalPayableAmount(customer,
						products)));
	}

	/**
	 * Customer joined not more than 2 years, and bought grocery products hence
	 * no discounts provided on total price Total bill is 60, Net payable is 60
	 */
	@Test
	public void testCustomerForNotMoreThan2YrsGrocery() {
		Customer customer = CustomerProductsBuilder
				.buildCustomerNotMoreThan2Yrs();
		List<Product> products = CustomerProductsBuilder.buildGroceryProducts();
		assertEquals(
				new Double(60),
				new Double(service.calculateTotalPayableAmount(customer,
						products)));
	}

	/**
	 * Customer is an employee, and bought non grocery products hence discounts
	 * provided on total price Total bill is 500, Employee disc is 30% which is
	 * (500-150) = 350, 5 dollars for every 100 of 350, hence 15 dollars less
	 * Net payable is 500-150-15 = 335
	 */
	@Test
	public void testEmployeeNonGrocery() {
		Customer customer = CustomerProductsBuilder.buildEmployeeCust();
		List<Product> products = CustomerProductsBuilder
				.buildNonGroceryProducts();
		assertEquals(
				new Double(335),
				new Double(service.calculateTotalPayableAmount(customer,
						products)));
	}

	/**
	 * Customer is an affiliate, and bought non grocery products hence discounts
	 * provided on total price Total bill is 500, Affiliate disc is 10% which is
	 * (500-50) = 450, 5 dollars for every 100 of 450, hence 20 dollars less Net
	 * payable is 500-50-20 = 430
	 */
	@Test
	public void testAffiliateNonGrocery() {
		Customer customer = CustomerProductsBuilder.buildAffiliateCust();
		List<Product> products = CustomerProductsBuilder
				.buildNonGroceryProducts();
		assertEquals(
				new Double(430),
				new Double(service.calculateTotalPayableAmount(customer,
						products)));
	}

	/**
	 * Has been a customer for more than 2 years, and bought non grocery
	 * products hence discounts provided on total price Total bill is 500,
	 * Affiliate disc is 5% which is (500-25) = 475, 5 dollars for every 100 of
	 * 475, hence 20 dollars less Net payable is 500-25-20 = 455
	 */
	@Test
	public void testCustomerForMoreThan2YrsNonGrocery() {
		Customer customer = CustomerProductsBuilder.buildCustomerMoreThan2Yrs();
		List<Product> products = CustomerProductsBuilder
				.buildNonGroceryProducts();
		assertEquals(
				new Double(455),
				new Double(service.calculateTotalPayableAmount(customer,
						products)));
	}

	/**
	 * Has been a customer for not more than 2 years, and bought non grocery
	 * products , not eligible for % discount Total bill is 500, 5 dollars for
	 * every 100 25, hence 20 dollars less Net payable is 500-25 = 475
	 */
	@Test
	public void testCustomerForNotMoreThan2YrsNonGrocery() {
		Customer customer = CustomerProductsBuilder
				.buildCustomerNotMoreThan2Yrs();
		List<Product> products = CustomerProductsBuilder
				.buildNonGroceryProducts();
		assertEquals(
				new Double(475),
				new Double(service.calculateTotalPayableAmount(customer,
						products)));
	}
}
