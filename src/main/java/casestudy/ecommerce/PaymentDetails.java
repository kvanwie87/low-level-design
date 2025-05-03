package casestudy.ecommerce;

public class PaymentDetails {
	// PaymentDetails - pojo with payment info(ids, cards, account ids, tokens, etc)
	// Payment - interface for the different kinds of payments
	// PaymentFactory - transform PaymentDetail to Payment
	// PaymentProcessor - interface for handling payments
	// ConcretePaymentProcessors for each of the types of payment
	// How to map payment to processor in an extendable way??
	
	
	
	// DelegatePaymentProcessor implements PaymentProcessor
	// Map<Class, PaymentProcessor> delegates;
	// delegates.get(payment.getClass()).process(payment);
	
	// PaymentMediator
	// Map<Class, PaymentProcessor> processors;
	// processors.get(payment.getClass()).process(payment);
}
