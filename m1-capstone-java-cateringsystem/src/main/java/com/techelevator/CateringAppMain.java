package com.techelevator;

import java.math.BigDecimal;

public class CateringAppMain {
	
	private UserInterface userInterface;
	
	private Inventory inventory;
	
	private CashBox cashBox;
	
	private Cart cart;
	
	private Change change;
	
	private AuditWriter writer;
	
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
		
		writer = new AuditWriter();
		
		change = new Change();
		
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
				//check amount to add, if appropriate add to balance
				BigDecimal amountToAdd = userInterface.displayAmountToDeposit();
				if(amountToAdd.compareTo(new BigDecimal(0)) == 0) {
					userInterface.displayErrorMessage(0);
				}
				else if(cashBox.checkBalanceStaysBelow5000(amountToAdd)) {
					BigDecimal currentBalance = cashBox.addToBalance(amountToAdd);
					writer.createAddToBalance(amountToAdd, currentBalance);
					
				}
				else {
					userInterface.displayErrorMessage(5);
				}
				userInterface.displayCurrentBalance(cashBox.getCurrentBalance());
			}
			
			else if(response.equals(SELECT_PRODUCTS)) {
				String sku = userInterface.displaySkuChoice();
				//checking if product key exists
				if(inventory.checkInventoryExists(sku)) {
					int amount = userInterface.displayAmountChoice();
					//checking if enough exist to fill order
					if(inventory.checkAmountExists(sku, amount)) {
						//checking if customer can afford order
						if(inventory.checkBalance(sku, amount, cashBox.getCurrentBalance())) {
							//buying product and placing it in cart
							Product product = inventory.buyProduct(sku, amount, cashBox.getCurrentBalance());
							cart.createLineItem(amount, product);
							cashBox.subtractFromBalance(amount, product);
							//adding to audit
							BigDecimal subTotal = new BigDecimal(amount).multiply(product.getPrice());
							writer.createBuyAction(product, amount, subTotal, cashBox.getCurrentBalance());
							
						}
						else {
							userInterface.displayErrorMessage(4);
						}
						//print balance after a purchase
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
				//printing out cart, clearing cart
				userInterface.displayCartatCheckOut(cart.calculateTotalSpent(), cart.retrieveCart());   
				cart.clearCart();
				
				//writing audit to give change, clearing balance
				writer.createGiveChange(change.giveChange(cashBox.getCurrentBalance()), cashBox.getCurrentBalance());
				cashBox.setCurrentBalance(new BigDecimal(0));
				running = false;
			}
			
			else {
				userInterface.displayErrorMessage(1);
			}
		}
		

	}
	

}
