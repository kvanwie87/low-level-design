package casestudy.ecommerce;

import java.util.List;

public interface Filter {
	public List<Product> filter(List<Product> products, FilterInfo filterInfo);
}
