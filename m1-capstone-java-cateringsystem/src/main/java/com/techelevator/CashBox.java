package com.techelevator;

import java.math.BigDecimal;

public class CashBox {
	
	private BigDecimal currentBalance = new BigDecimal(0);
	
	public BigDecimal addToBalance(BigDecimal amount) {
		currentBalance = currentBalance.add(amount);
		
		return currentBalance;
	}
	

	public BigDecimal getCurrentBalance() {
		return currentBalance;
	}
	
	public boolean checkBalanceStaysBelow5000(BigDecimal amountToAdd) {
		if(amountToAdd.add(currentBalance).compareTo(new BigDecimal(5000)) == 1) {
			return false;
		}
		else {
			return true;
		}
	}
	public BigDecimal subtractFromBalance(int amount, Product product) {
		BigDecimal totalAmount = new BigDecimal(amount).multiply(product.getPrice());
		
		currentBalance = currentBalance.subtract(totalAmount);
		
		return currentBalance;
	}
	
}
