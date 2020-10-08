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

	public void addToReport(String action, BigDecimal moneyInOrOut, BigDecimal currentBalance) {

		moneyInOrOut = moneyInOrOut.setScale(2, RoundingMode.HALF_UP);
		currentBalance = currentBalance.setScale(2, RoundingMode.HALF_UP);
		LocalDateTime myDate = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss aa");
		String formattedDate = myDate.format(formatter);
		writer.println(formattedDate + " " + action + " $" + moneyInOrOut + " $" + currentBalance);

	}
}
