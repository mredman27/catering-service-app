package com.techelevator;

import java.math.BigDecimal;

public class LineItem {
	
	private int quantity;
	
	private BigDecimal subTotal;
	
	private Product product;
	
	public LineItem(int quantity, Product product) {
		this.quantity = quantity;
		this.product = product;
		subTotal = new BigDecimal(getQuantity()).multiply(getProduct().getPrice());
		
	}

	public int getQuantity() {
		return quantity;
	}

	public Product getProduct() {
		return product;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}
	
	
}
