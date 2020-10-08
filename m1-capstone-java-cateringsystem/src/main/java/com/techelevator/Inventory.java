package com.techelevator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Inventory {
	
	private InventoryFileReader reader;
	
	private AuditWriter writer;
	
	private Map<String, InventoryItem> inventoryMap;
	
	public Inventory() {
		reader = new InventoryFileReader();
		inventoryMap = reader.loadInventoryFromFile();
		writer = new AuditWriter();
	}
	
	public List<InventoryItem> retrieveItems(Map<String, InventoryItem> testMap) {
		
		
		
		
		
		return new ArrayList<InventoryItem>();
	}
	
	
	public boolean checkInventoryExists (String sku, Map<String, InventoryItem> testMap) {
		
		
		return true;
	}
	
	
	public boolean checkAmountExists(String sku, int amount, Map<String, InventoryItem> testMap) {
		
		
		return true;
	}
	
	
	public Product buyProduct(String sku, int amount, BigDecimal currentBalance, Map<String, InventoryItem> testMap) {
		
		
		return new Product(null, null, null, null);
	}

	
	
	
	
	
	
	public Map<String, InventoryItem> getInventoryMap() {
		return inventoryMap;
	}

	public void setInventoryMap(Map<String, InventoryItem> inventoryMap) {
		this.inventoryMap = inventoryMap;
	}
	

}
