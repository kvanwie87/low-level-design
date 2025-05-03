package casestudy.ecommerce;

import java.util.ArrayList;
import java.util.List;

public class PriceFilter implements Filter{

	public PriceFilter() {
		
	}
	@Override
	public List<Product> filter(List<Product> products, FilterInfo filterInfo) {
		if(!(filterInfo.priceMin.isPresent() || filterInfo.priceMax.isPresent())) {
			return products;
		} 
		double minPrice = filterInfo.priceMin.orElse(0.0);
		double maxPrice = filterInfo.priceMax.orElse(Double.MAX_VALUE);
		List<Product> result = new ArrayList<Product>();
		for(Product product : products) {
			if(product.price >= minPrice && product.price <= maxPrice) {
				result.add(product);
			}
		}
		return result;
	}
}
