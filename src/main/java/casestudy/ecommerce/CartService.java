package casestudy.ecommerce;

public class CartService {
	private CartDAO dao;
	public Cart getCart(String cartId) {
		return dao.getCartById(cartId);
	}
	public void addToCart(User user, Cart cart, Product product, int quantity) {
		// TODO logic
		cart.add(product, quantity);
	}
}
