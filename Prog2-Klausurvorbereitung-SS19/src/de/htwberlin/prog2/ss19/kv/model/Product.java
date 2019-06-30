package de.htwberlin.prog2.ss19.kv.model;

import de.htwberlin.prog2.ss19.kv.exc.InvalidValueException;

public class Product implements Comparable<Product>{
	
	private String name;
	private String category;
	private double price;
	
	
	public Product(String name, String category, double price) throws Exception{
		super();
		if(name.isEmpty())
			throw new InvalidValueException("Name cannot be empty");
		else
			this.name = name;
		
		if(category.isEmpty())
			throw new InvalidValueException("Category cannot be empty");
		else
			this.category = category;
		if(price <= 0)
			throw new InvalidValueException("Price must be greater than zero");
		else
			this.price = price;
	}
	
	public String getName() {
		return name;
	}
	public String getCategory() {
		return category;
	}
	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return name + " (" + category + ") - " + price ;
	}

	public int compareTo(Product product2) {
		return this.name.compareTo(product2.getName());
	}
	
	
	

}
