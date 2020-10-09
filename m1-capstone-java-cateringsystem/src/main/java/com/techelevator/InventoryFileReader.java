package com.techelevator;

import java.io.File;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

import org.springframework.util.LinkedCaseInsensitiveMap;

public class InventoryFileReader {
	
	
	public Map<String, InventoryItem> loadInventoryFromFile() {
		
		Map<String, InventoryItem> tempMap = new LinkedCaseInsensitiveMap<>();
		
		File inventoryFile = new File("cateringsystem.csv");
		
		try(Scanner fileScanner = new Scanner(inventoryFile)) {
			
			while(fileScanner.hasNextLine()) {
				String thisLine = fileScanner.nextLine();
				
				String[] eachEntry = thisLine.split("\\|");
				
				BigDecimal price = new BigDecimal(eachEntry[2]);
				
				Product tempProduct = new Product(eachEntry[0], eachEntry[1], price, eachEntry[3]);
				
				InventoryItem tempInventoryItem = new InventoryItem(tempProduct);
				
				tempMap.put(eachEntry[0], tempInventoryItem);
			}
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return tempMap;
	}
	
	
	

}
