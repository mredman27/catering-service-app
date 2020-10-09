package com.techelevator;

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
			System.out.println("");
		}
		
	}
	public String displayOrderMenu() {
		
		System.out.println("(1) Add money");
		System.out.println("(2) Select products");
		System.out.println("(3) Complete transaction" );
		
		return keyboard.nextLine();
	}

}
