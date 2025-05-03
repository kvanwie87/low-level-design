package casestudy.ecommerce;

import java.util.ArrayList;
import java.util.List;

public class AggregateFilter implements Filter {
	public List<Filter> filters = new ArrayList<Filter>();
	@Override
	public List<Product> filter(List<Product> products, FilterInfo filterInfo) {
		for(Filter filter : filters) {
			products = filter.filter(products, filterInfo);
		}
		return products;
	}

}
