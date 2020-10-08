package com.techelevator;

import java.util.Map;

public class Inventory {
	
	private InventoryFileReader reader;
	
	private Map<String, InventoryItem> inventoryMap;
	
	public Inventory() {
		reader = new InventoryFileReader();
	}
	
	

}
