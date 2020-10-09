package com.techelevator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
	
	private Scanner keyboard = new Scanner(System.in);
	
	
	public String printMainMenu() {
		
		System.out.println("(1) Display catering items");
		System.out.println("(2) Order");
		System.out.println("(3) Quit" );
		
		return keyboard.nextLine();
	}
	
	public void displayErrorMessage(int error) {
		if(error == 1) {
			System.out.println("Invalid choice, try again");
		}
		if(error == 2) {
			System.out.println("That item is not available");
		}
		if(error == 3) {
			System.out.println("Sorry, we only accept bills");
		}
		if(error == 4) {
			System.out.println("Insufficient funds");
		}
		if(error == 5) {
			System.out.println("Amount exceeds $5,000 limit");
		}
		if(error == 6 ) {
			System.out.println("Insufficient stock");
		}
		
	}
	public String displayOrderMenu() {
		
		System.out.println("(1) Add money");
		System.out.println("(2) Select products");
		System.out.println("(3) Complete transaction" );
		
		return keyboard.nextLine();
	}
	
	public void displayItems(List<InventoryItem> items) {
		for(InventoryItem item : items) {
			String itemType = "";
			
			System.out.printf("%-3s", item.getQuantity());
			System.out.printf("%-3s", item.getProduct().getSku());
			System.out.printf("%-20s", item.getProduct().getName());
			System.out.print("$" + item.getProduct().getPrice() + "\n");
		}
		System.out.println();
	}
	
	public String displaySkuChoice() {
		System.out.println("What is the product code for the item you would like to purchase?");
		return keyboard.nextLine();
	}
	
	public int displayAmountChoice() {
		System.out.println("How many would you like?");
		int amount = keyboard.nextInt();
		keyboard.nextLine();
		return amount;
		
	}
	
	public BigDecimal displayAmountToDeposit() {
		System.out.println("How much would you like to add?");
		double amountEntered = Double.parseDouble(keyboard.nextLine());
		if(amountEntered <= 0) {
			displayErrorMessage(1);
			return new BigDecimal(0);
		}
		else if(amountEntered % 1 == 0) {
			return new BigDecimal(amountEntered);
		}
		else {
			displayErrorMessage(3);
			return new BigDecimal(0);
		}
		
		
	}
	
	public void displayCurrentBalance(BigDecimal currentBalance) {
		System.out.println("Your current Balance is $" + currentBalance.setScale(2, RoundingMode.HALF_UP));
		
	}
	
	public void displayCartatCheckOut(BigDecimal amountSpent, List<LineItem> lineItems) {
		for(LineItem item : lineItems) {
			System.out.printf("%-5s", item.getQuantity());
			String type = "";
			if(item.getProduct().getType().equals("B")) {
				type = "Beverage";
			}
			if(item.getProduct().getType().equals("E")) {
				type = "Entree";
			}
			if(item.getProduct().getType().equals("A")) {
				type = "Appetizer";
			}
			if(item.getProduct().getType().equals("D")) {
				type = "Dessert";
			}
			System.out.printf("%-12s", type);
			System.out.printf("%-20s", item.getProduct().getName());
			System.out.printf("$%-8s", item.getProduct().getPrice());
			System.out.printf("$%-6s", item.getSubTotal());
			System.out.println();
			
		}
		System.out.println();
		System.out.println("Total: " + amountSpent);
	}
}






