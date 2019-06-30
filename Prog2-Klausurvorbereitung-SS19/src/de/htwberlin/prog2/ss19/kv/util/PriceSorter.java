package de.htwberlin.prog2.ss19.kv.util;

import java.util.Comparator;

import de.htwberlin.prog2.ss19.kv.model.Product;

public class PriceSorter implements Comparator<Product> {
	public int compare(Product product1, Product product2) {
		return -1 * Double.compare(product1.getPrice(), product2.getPrice());
	}

}
