package com.techelevator;

public class InventoryItem {
	
	private int quantity = 50;
	
	private Product product;

	public InventoryItem(Product product) {
		this.product = product;
	}

	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public int getQuantity() {
		return quantity;
	}


	public Product getProduct() {
		return product;
	}
	
	

}
