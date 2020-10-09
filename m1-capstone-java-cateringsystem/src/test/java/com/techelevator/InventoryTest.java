package com.techelevator;



import org.junit.Before;
import org.junit.Test;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.*;;

public class InventoryTest {
	
	Inventory inventory;
	
	Map<String, InventoryItem> inventoryMap;
	//List<InventoryItem> inventoryList;
	InventoryItem testItem1;
	InventoryItem testItem2;
	InventoryItem testItem3;
	InventoryItem testItem4;
	Product testProduct1;
	Product testProduct2;
	Product testProduct3;
	Product testProduct4;
	BigDecimal currentBalance;
	
	@Before
	public void setUp() {
		inventory = new Inventory();
		inventoryMap = new LinkedCaseInsensitiveMap<>();
		inventory.setInventoryMap(inventoryMap);
		//inventoryList = new ArrayList<InventoryItem>();
		testProduct1 = new Product("B1","Soda", new BigDecimal(1.50), "B");
		testProduct2 = new Product("A1", "Tropical fruit bowl", new BigDecimal(3.50), "A");
		testProduct3 = new Product("E1", "Baked Chicken", new BigDecimal(8.85), "E");
		testProduct4 = new Product("D1", "NY Style Cheesecake", new BigDecimal(2.55), "D");
		testItem1 = new InventoryItem(testProduct1);
		testItem2 = new InventoryItem(testProduct2);
		testItem3 = new InventoryItem(testProduct3);
		testItem4 = new InventoryItem(testProduct4);
		
//		inventoryList.add(testItem1);
//		inventoryList.add(testItem2);
//		inventoryList.add(testItem3);
//		inventoryList.add(testItem4);
	}
	
//	@Test
//	public void retrieveItems() {
//		Assert.assertEquals(inventoryList, inventory.retrieveItems(inventoryMap));
//	}
//	
	@Test
	public void checkInventoryExists() {
		inventoryMap.put("B1", testItem1);
		inventoryMap.put("A1", testItem2);
		inventoryMap.put("E1", testItem3);
		inventoryMap.put("D1", testItem4);
		
//		Assert.assertTrue(inventory.checkInventoryExists("B1", inventoryMap));
//		Assert.assertFalse(inventory.checkInventoryExists(null, inventoryMap));
//		Assert.assertTrue(inventory.checkInventoryExists("a1", inventoryMap));
//		Assert.assertFalse(inventory.checkInventoryExists("ab", inventoryMap));
//		Assert.assertTrue(inventory.checkInventoryExists("D1", inventoryMap));
//		Assert.assertFalse(inventory.checkInventoryExists("D2", inventoryMap));
//		Assert.assertFalse(inventory.checkInventoryExists("1", inventoryMap));
	}
	
	@Test
	public void checkAmountExistsQuantitiesAt50() {
		inventoryMap.put("B1", testItem1);
		inventoryMap.put("A1", testItem2);
		inventoryMap.put("E1", testItem3);
		inventoryMap.put("D1", testItem4);
		
//		Assert.assertTrue(inventory.checkAmountExists("B1", 10, inventoryMap));
//		Assert.assertFalse(inventory.checkAmountExists("B1", 51, inventoryMap));
//		Assert.assertTrue(inventory.checkAmountExists("A1", 50, inventoryMap));
//		Assert.assertFalse(inventory.checkAmountExists("B1", 100, inventoryMap));
	}
	
	@Test
	public void checkAmountExistsQuantitiesLessThan50() {
		testItem1.setQuantity(15);
		testItem2.setQuantity(1);
		testItem3.setQuantity(0);
		testItem4.setQuantity(49);
		
		inventoryMap.put("B1", testItem1);
		inventoryMap.put("A1", testItem2);
		inventoryMap.put("E1", testItem3);
		inventoryMap.put("D1", testItem4);
		
//		Assert.assertTrue(inventory.checkAmountExists("B1", 10, inventoryMap));
//		Assert.assertFalse(inventory.checkAmountExists("B1", 16, inventoryMap));
//		Assert.assertTrue(inventory.checkAmountExists("A1", 1, inventoryMap));
//		Assert.assertFalse(inventory.checkAmountExists("E1", 1, inventoryMap));
	}
	
	@Test
	public void buyProduct() {
		inventoryMap.put("B1", testItem1);
		inventoryMap.put("A1", testItem2);
		inventoryMap.put("E1", testItem3);
		inventoryMap.put("D1", testItem4);
		
//		Assert.assertEquals(testProduct1, inventory.buyProduct("B1", 5, new BigDecimal(100), inventoryMap));
//		Assert.assertEquals(testProduct2, inventory.buyProduct("A1", 49, new BigDecimal(172), inventoryMap));
		
	}
	
	@Test
	public void checkBalanceCanAfford() {
		inventoryMap.put("B1", testItem1);
		inventoryMap.put("A1", testItem2);
		inventoryMap.put("E1", testItem3);
		inventoryMap.put("D1", testItem4);
		currentBalance = new BigDecimal(500);
		
		//Assert.assertTrue(inventory.checkBalance("B1", 1, currentBalance, inventoryMap));
	}
	
	@Test
	public void checkBalanceCannotAfford() {
		inventoryMap.put("B1", testItem1);
		inventoryMap.put("A1", testItem2);
		inventoryMap.put("E1", testItem3);
		inventoryMap.put("D1", testItem4);
		currentBalance = new BigDecimal(2);
		
		//Assert.assertFalse(inventory.checkBalance("B1", 10, currentBalance, inventoryMap));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
