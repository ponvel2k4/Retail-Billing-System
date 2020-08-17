package com.retail.billing.base;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.retail.billing.domain.Customer;
import com.retail.billing.domain.CustomerType;
import com.retail.billing.domain.Product;
import com.retail.billing.domain.ProductCategory;

/**
 * Builder class to construct customer and product list for different categories
 * 
 * @author ponvel
 *
 */
public class CustomerProductsBuilder {

	public static Customer buildAffiliateCust() {
		Customer customer = new Customer(CustomerType.AFFILIATE, "John", null);
		return customer;
	}

	public static Customer buildEmployeeCust() {
		Customer customer = new Customer(CustomerType.EMPLOYEE, "Parker", null);
		return customer;
	}

	public static Customer buildCustomerMoreThan2Yrs() {
		Customer customer = new Customer(CustomerType.CUSTOMER_FOR_ATLST_2YRS,
				"Mary", LocalDateTime.of(2015, 2, 17, 11, 05));
		return customer;
	}

	public static Customer buildCustomerNotMoreThan2Yrs() {
		Customer customer = new Customer(CustomerType.CUSTOMER_FOR_ATLST_2YRS,
				"Lewis", LocalDateTime.of(2019, 2, 17, 11, 05));
		return customer;
	}

	/**
	 * Total bill value of this method is (1*20)+(2*15)+(1*10) = 60
	 * 
	 * @return List<Product>
	 */
	public static List<Product> buildGroceryProducts() {
		Product product1 = new Product("Milk", 1, 20, ProductCategory.GROCERY);
		Product product2 = new Product("Rice", 2, 15, ProductCategory.GROCERY);
		Product product3 = new Product("Oil", 1, 10, ProductCategory.GROCERY);
		List<Product> products = new ArrayList<Product>();
		products.add(product1);
		products.add(product2);
		products.add(product3);
		return products;
	}

	/**
	 * Total bill value of this method is (1*200)+(2*150) = 500
	 * 
	 * @return List<Product>
	 */
	public static List<Product> buildNonGroceryProducts() {
		Product product1 = new Product("Television", 1, 200,
				ProductCategory.OTHERS);
		Product product2 = new Product("Furniture", 2, 150,
				ProductCategory.OTHERS);
		List<Product> products = new ArrayList<Product>();
		products.add(product1);
		products.add(product2);
		return products;
	}
}
