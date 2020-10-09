package com.techelevator;

public class CateringAppMain {
	
	private UserInterface userInterface;
	
	private Inventory inventory;
	
	private final String DISPLAY_CATERING_ITEMS = "1";
	
	private final String ORDER = "2";
	
	private final String QUIT = "3";
	
	private final String ADD_MONEY = "1";
	
	private final String SELECT_PRODUCTS = "2";
	
	private final String COMPLETE_TRANSACTION = "3";
	
	public CateringAppMain() {
		userInterface = new UserInterface();
		
		inventory = new Inventory();
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
				inventory.retrieveItems();			
			}
			
			else if(response.equals(ORDER)) {
				//open order menu
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
				//add money
			}
			
			else if(response.equals(SELECT_PRODUCTS)) {
				//select products
			}
			
			else if(response.equals(COMPLETE_TRANSACTION)) {
				running = false;
			}
			
			else {
				userInterface.displayErrorMessage(1);
			}
		}
		
		
		
		
		
		
		
		
		
		
		
	}
	

}
