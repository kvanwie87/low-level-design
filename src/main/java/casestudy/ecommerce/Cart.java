package casestudy.ecommerce;

import java.util.List;

public class Cart {
	public String id;
	public User user;
	public List<CartEntry> entries;
	
	public void add(Product product, int quantity) {
		addEntry(new CartEntry(product, quantity));
	}
	
	public void addEntry(CartEntry entry) {
		entries.add(entry);
	}
	
	public void removeEntry(CartEntry entry) {
		entries.remove(entry);
	}
	
	public void updateEntry(CartEntry entry) {
		
	}
	
	public void clear() {}
	
	// CartAPI
	// CartService
	// CartDAO
	// Cart
	// Product, Quantity
	// User
	
}
