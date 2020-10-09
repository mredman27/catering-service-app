package com.techelevator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Change {
	
	private int twenties;
	private int tens;
	private int fives;
	private int ones;
	private int quarters;
	private int dimes;
	private int nickels;
	
	
	public int[] giveChange(BigDecimal balance) {
		
		balance = balance.multiply(new BigDecimal(1000));
		
		
		twenties = balance.divide(new BigDecimal(20000)).setScale(2, RoundingMode.HALF_UP).intValue();
		balance = balance.subtract(new BigDecimal(twenties).multiply(new BigDecimal(20000)));
		
		tens =  balance.divide(new BigDecimal(10000)).setScale(2, RoundingMode.HALF_UP).intValue();
		balance = balance.subtract(new BigDecimal(tens).multiply(new BigDecimal(10000)));
		
		fives =  balance.divide(new BigDecimal(5000)).setScale(2, RoundingMode.HALF_UP).intValue();
		balance = balance.subtract(new BigDecimal(fives).multiply(new BigDecimal(5000)));
		
		ones = balance.divide(new BigDecimal(1000)).setScale(2, RoundingMode.HALF_UP).intValue();
		balance = balance.subtract(new BigDecimal(ones).multiply(new BigDecimal(1000)));
		
		quarters = balance.divide(new BigDecimal(250)).setScale(2, RoundingMode.HALF_UP).intValue();
		balance = balance.subtract(new BigDecimal(quarters).multiply(new BigDecimal(250)));
		
		dimes = balance.divide(new BigDecimal(100)).setScale(2, RoundingMode.HALF_UP).intValue();
		balance = balance.subtract(new BigDecimal(dimes).multiply(new BigDecimal(100)));
		
		nickels = balance.divide(new BigDecimal(50)).setScale(2, RoundingMode.HALF_UP).intValue();
		balance = balance.subtract(new BigDecimal(nickels).multiply(new BigDecimal(50)));
		
		return new int[] {twenties, tens, fives, ones, quarters, dimes, nickels};
		
		
	}
}
