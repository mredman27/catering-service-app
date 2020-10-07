package com.techelevator;

import com.techelevator.view.UserInterface;

public class CateringSystemCLI {

	private UserInterface ui;

	public CateringSystemCLI(UserInterface ui) {
		this.ui = ui;
	}
	
	public static void main(String[] args) {
		UserInterface menu = new UserInterface();
		CateringSystemCLI cli = new CateringSystemCLI(menu);
		cli.run();
	}	

	
	
	public void run() {
		
		while (true) {    // probably want to change the 'true' to a variable you can set to false when exiting

			/*
			Display the Starting Menu using the UI class...
			*/
		}
	}
	
	



}
