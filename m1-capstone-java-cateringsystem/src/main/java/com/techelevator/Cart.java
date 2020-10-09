package com.techelevator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cart {
	
	private List<LineItem> currentOrder = new ArrayList<LineItem>();;
	
	public void createLineItem(int amount, Product product) {
		LineItem lineItem = new LineItem(amount, product);
		currentOrder.add(lineItem);
	}
	
	public BigDecimal calculateTotalSpent() {
		BigDecimal totalSpent = new BigDecimal(0);
		for(LineItem lineItem : currentOrder) {
			BigDecimal subTotal = lineItem.getSubTotal();
			totalSpent = totalSpent.add(subTotal);
			
		}
		return totalSpent;
	}
	
	public List<LineItem> retrieveCart() {
		List<LineItem> tempCurrentOrder = currentOrder;
		
		return tempCurrentOrder;
	}
	public void clearCart() {
		currentOrder.clear();
	}
}
