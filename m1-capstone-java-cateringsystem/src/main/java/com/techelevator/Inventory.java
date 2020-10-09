package com.techelevator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Inventory {
	
	private InventoryFileReader reader;
	
	private AuditWriter writer;
	
	private Map<String, InventoryItem> inventoryMap;
	
	private List<InventoryItem> inventoryList;
	
	public Inventory() {
		reader = new InventoryFileReader();
		inventoryMap = reader.loadInventoryFromFile();
		writer = new AuditWriter();
	}
	
	public List<InventoryItem> retrieveItems() {
		inventoryList = new ArrayList<InventoryItem>();
		
		Set<String> keySet = inventoryMap.keySet();
		
		
		for(String key : keySet) {
			InventoryItem tempItem = inventoryMap.get(key);
			inventoryList.add(tempItem);
		}
		
		return inventoryList;
	}
	
	
	public boolean checkInventoryExists (String sku, Map<String, InventoryItem> testMap) {
		if (sku == null) {
			return false;
		}
		if(testMap.containsKey(sku.toUpperCase()) || testMap.containsKey(sku.toLowerCase())) {
			return true;
		}
		else {
			return false;
		}
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
