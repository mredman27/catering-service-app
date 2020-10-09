package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
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

	public void createBuyAction(Product product, int amount) {
		String productName = product.getName();
		String productCode = product.getSku();
		BigDecimal price = product.getPrice();
		BigDecimal cost = price.multiply(new BigDecimal(amount)).setScale(2, RoundingMode.HALF_UP);
		
		String action = amount + " " + productName + " " + productCode;
		
		//addToReport(action, cost, cost);
	}
	
	public void createAddToBalance(BigDecimal amountAdded, BigDecimal currentBalance) {
		
	}
	
	public void addToReport(String action, BigDecimal moneyInOrOut, BigDecimal currentBalance) {

		
		
		LocalDateTime myDate = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss aa");
		String formattedDate = myDate.format(formatter);
		writer.println(formattedDate + " " + action + " $" + moneyInOrOut + " $" + currentBalance);

	}
}
