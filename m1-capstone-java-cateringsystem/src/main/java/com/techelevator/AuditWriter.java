package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class AuditWriter {

	private File report;

	private PrintWriter writer;

	public AuditWriter() {

		report = new File("auditreport.txt");

		if (!report.exists()) {
			try {
				report.createNewFile();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		try {
			writer = new PrintWriter(report);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}

	public void createBuyAction(Product product, int amount, BigDecimal amountSpent, BigDecimal currentBalance) {
		String productName = product.getName();
		String productCode = product.getSku();
		String action = amount + " " + productName + " " + productCode;
		
		addToReport(action, amountSpent, currentBalance);
	}
	
	public void createAddToBalance(BigDecimal amountAdded, BigDecimal currentBalance) {
		String action = "ADD MONEY:  ";
		addToReport(action, amountAdded, currentBalance);
		
	}
	
	public void createGiveChange(int[] changeArray, BigDecimal currentBalance) {
		String twenties = Integer.toString(changeArray[0]);
		String tens  = Integer.toString(changeArray[1]);
		String fives = Integer.toString(changeArray[2]);
		String ones = Integer.toString(changeArray[3]);
		String quarters = Integer.toString(changeArray[4]);
		String dimes = Integer.toString(changeArray[5]);
		String nickels = Integer.toString(changeArray[6]);
		
		String action = "GIVE CHANGE: ";
		
		addToReport(action, currentBalance, new BigDecimal(0));
		writer.println("CHANGE GIVEN: " + twenties + " twenties " + 
				tens + " tens " + fives + " fives " + ones + " ones " + quarters + " quarters " +
				dimes + " dimes " + nickels + " nickels ");
		writer.flush();
	}
	
	public void addToReport(String action, BigDecimal moneyInOrOut, BigDecimal currentBalance) {

		
		
		LocalDateTime myDate = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss a");
		String formattedDate = myDate.format(formatter);
		writer.println(formattedDate + " " + action + " $" + moneyInOrOut + " $" + currentBalance);
		writer.flush();
	}
}
