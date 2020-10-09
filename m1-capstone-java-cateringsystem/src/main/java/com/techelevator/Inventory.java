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
	
	
	public boolean checkInventoryExists (String sku) {
		if (sku == null) {
			return false;
		}
		if(inventoryMap.containsKey(sku)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public boolean checkAmountExists(String sku, int amount) {
		if (amount == 0) { 
			return false;
		}
		InventoryItem currentItem = inventoryMap.get(sku);

		if(amount <= currentItem.getQuantity()) {
			return true;
		}
		else {
			return false;
		}
		
		
		
	}
	
	public boolean checkBalance(String sku, int amount, BigDecimal currentBalance) {
		InventoryItem currentItem = inventoryMap.get(sku);
		BigDecimal currentTotalPrice = (currentItem.getProduct().getPrice()).multiply(new BigDecimal(amount));
		if(currentTotalPrice.compareTo(currentBalance) == 0 || 
				currentTotalPrice.compareTo(currentBalance) == -1) {
			return true;
		}
		else {
			return false;
		}
		
		
	}
	
	
	
	public Product buyProduct(String sku, int amount, BigDecimal currentBalance) {
		InventoryItem currentItem = inventoryMap.get(sku);
		Product currentProduct = currentItem.getProduct();
		currentItem.setQuantity(currentItem.getQuantity()-amount);
		inventoryMap.put(sku, currentItem);
		
		
		
		return currentProduct;
	}
	
	

	
	
	
	
	
	
	public Map<String, InventoryItem> getInventoryMap() {
		return inventoryMap;
	}

	public void setInventoryMap(Map<String, InventoryItem> inventoryMap) {
		this.inventoryMap = inventoryMap;
	}
	

}
