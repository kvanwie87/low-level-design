package casestudy.stockbroadcast;

import java.util.ArrayList;
import java.util.List;

public class StockExchange implements Publisher {
	private List<Subscriber> subscribers = new ArrayList<Subscriber>();
	
	public StockExchange() {
		
	}
	public void subscribe(Subscriber subscriber) {
		subscribers.add(subscriber);
	}

	public void unsubscribe(Subscriber subscriber) {
		subscribers.remove(subscriber);
	}
	
	public void updateStock(String stockName, double price) {
		publish(new StockPriceEvent(stockName, price));
	}

	public void publish(Event event) {
		for(Subscriber sub : subscribers) {
			sub.update(event);
		}
	}

}
