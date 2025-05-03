package casestudy.stockbroadcast;

public class Runner {
	public static void main(String[] args) {
		// could use mediator to handle communication between the publisher and subscriber 
		StockExchange nyse = new StockExchange();
		StockExchange nasdaq = new StockExchange();
		
		ConsoleStockSubscriber sub1 = new ConsoleStockSubscriber("1");
		ConsoleStockSubscriber sub2 = new ConsoleStockSubscriber("2");
		ConsoleStockSubscriber sub3 = new ConsoleStockSubscriber("3");
		
		nyse.subscribe(sub1);
		nyse.subscribe(sub2);
		nasdaq.subscribe(sub2);
		nasdaq.subscribe(sub3);
		
		nyse.updateStock("NVDA", 123.5);
		nasdaq.updateStock("NVDA", 123.4);
	}
}
