package com.techelevator;

import java.math.BigDecimal;

public class Product {
	
	private String sku;
	
	private String name;
	
	private BigDecimal price;
	
	private String type;

	public Product(String sku, String name, BigDecimal price, String type) {
		super();
		this.sku = sku;
		this.name = name;
		this.price = price;
		this.type = type;
	}

	public String getSku() {
		return sku;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public String getType() {
		return type;
	}
	
	
	

}
