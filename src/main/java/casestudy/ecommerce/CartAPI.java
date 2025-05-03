package casestudy.ecommerce;

public class CartAPI {
	private CartService cartService;
	public void addToCart(AddToCartRequest request) {
		// Likely interact with a UserService using request.userId
		//
		// Authorization
		// Validation
		// Transform
		// Call CartService
		User user = request.user;
		Cart cart = cartService.getCart(request.cartId);
		Product product = null; // TODO invoke ProductService
		
		cartService.addToCart(user, cart, product, request.quantity);
	}
	
	public void checkout(CheckoutCartRequest request) {
		// Checkout
		// Cart details, payment details billing address, Shipping info, discounts, user info 
		// Authorization, Validation
		// Retrieve relevant infos
		// Create Order?
		// Reserve Item
		// Attempt to process payment
		// If failed unreserve item
		// else mark order as ready for fulfillment?
	}
}
