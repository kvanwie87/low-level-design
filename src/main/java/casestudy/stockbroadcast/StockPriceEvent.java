package casestudy.stockbroadcast;

public class StockPriceEvent implements Event {
	public String stockName;
	public double price;
	public StockPriceEvent(String stockName, double price) {
		this.stockName = stockName;
		this.price = price;
	}
}
