package casestudy.stockbroadcast;

public class ConsoleStockSubscriber  implements Subscriber {
	private String name;
	

	public ConsoleStockSubscriber(String name) {
		super();
		this.name = name;
	}


	public void update(Event event) {
		System.out.println(name + ": " + ((StockPriceEvent)event).stockName + " - " + ((StockPriceEvent)event).price);
	}

}
