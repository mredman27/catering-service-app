package com.techelevator;

import java.math.BigDecimal;

public class CateringAppMain {
	
	private UserInterface userInterface;
	
	private Inventory inventory;
	
	private CashBox cashBox;
	
	private Cart cart;
	
	private final String DISPLAY_CATERING_ITEMS = "1";
	
	private final String ORDER = "2";
	
	private final String QUIT = "3";
	
	private final String ADD_MONEY = "1";
	
	private final String SELECT_PRODUCTS = "2";
	
	private final String COMPLETE_TRANSACTION = "3";
	
	public CateringAppMain() {
		userInterface = new UserInterface();
		
		inventory = new Inventory();
		
		cashBox = new CashBox();
		
		cart = new Cart();
		
	}

	public static void main(String[] args) {
		
		CateringAppMain app = new CateringAppMain();
		
		app.run();
		
	
		

	}
	
	private void run() {
		
		boolean running = true;
		
		while(running) {
			String response = userInterface.printMainMenu();
			
			if(response.equals(DISPLAY_CATERING_ITEMS)) {	
				userInterface.displayItems(inventory.retrieveItems());
			}
			
			else if(response.equals(ORDER)) {
				orderMenuHandler();
				
			}
			
			else if(response.equals(QUIT)) {
				break;
			}
			
			else {
				userInterface.displayErrorMessage(1);
			}
		}
		
		System.out.println("Goodbye");
		System.exit(1);
	}
	
	private void orderMenuHandler() {
		
		boolean running = true;
		
		while(running) {
			String response = userInterface.displayOrderMenu();
			
			if(response.equals(ADD_MONEY)) {
				BigDecimal amountToAdd = userInterface.displayAmountToDeposit();
				if(cashBox.checkBalanceStaysBelow5000(amountToAdd)) {
					BigDecimal currentBalance = cashBox.addToBalance(amountToAdd);
					
				}
				else {
					userInterface.displayErrorMessage(5);
				}
				userInterface.displayCurrentBalance(cashBox.getCurrentBalance());
			}
			
			else if(response.equals(SELECT_PRODUCTS)) {
				String sku = userInterface.displaySkuChoice();
				if(inventory.checkInventoryExists(sku)) {
					int amount = userInterface.displayAmountChoice();
					if(inventory.checkAmountExists(sku, amount)) {
						if(inventory.checkBalance(sku, amount, cashBox.getCurrentBalance())) {
							Product product = inventory.buyProduct(sku, amount, cashBox.getCurrentBalance());
							cart.createLineItem(amount, product);
							cashBox.subtractFromBalance(amount, product);
							
						}
						else {
							userInterface.displayErrorMessage(4);
						}
						userInterface.displayCurrentBalance(cashBox.getCurrentBalance());
					}
					else {
						userInterface.displayErrorMessage(6);
					}
				}
				else {
					userInterface.displayErrorMessage(2);
				}
			}
			
			else if(response.equals(COMPLETE_TRANSACTION)) {
				userInterface.displayCartatCheckOut(cart.calculateTotalSpent(), cart.retrieveCart());   
				cart.clearCart();
				
				
				running = false;
			}
			
			else {
				userInterface.displayErrorMessage(1);
			}
		}
		
		
		
		
		
		
		
		
		
		
		
	}
	

}
