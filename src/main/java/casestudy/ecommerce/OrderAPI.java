package casestudy.ecommerce;

public class OrderAPI {
	// Requirements - Status/Cancellation/Refund
	// Typical layers API/Service/DAO
	// Basic validation/authorizations
	// endpoint for retrieve all orders for user id
	// endpoint for retrieve particular order details
	// endpoint for cancel by order id
	// 			validation of order date, status
	//			reverse the payment and then change order status to cancel, initiate restock
	
	// endpoint for refund
	// 			validation of order date, status
	//			mark order as pending return, once return reverse the payment and then change order status to cancel, initiate restock
}
