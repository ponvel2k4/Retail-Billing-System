package com.retail.billing.domain;

/**
 * 
 * @author ponvel
 *
 */
public class Product {

	private String productName;
	private int quantity;
	private double price;
	private ProductCategory category;
	private double totalCost;

	public Product(String productName, int quantity, double price,
			ProductCategory category) {
		super();
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.category = category;
		this.totalCost = price * quantity;
	}

	public String getProductName() {
		return productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public double getPrice() {
		return price;
	}

	/**
	 * Method to get the discounted price
	 * 
	 * @param product
	 * @param discountPercentage
	 * @return
	 */
	public double getDiscountedPrice(Product product, double discountPercentage) {
		if (product.getCategory().name() == ProductCategory.OTHERS.name()
				&& discountPercentage != 0) {
			return (totalCost - totalCost * discountPercentage / 100);
		}
		return totalCost;
	}
}
