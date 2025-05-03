package casestudy.ecommerce;

import java.util.ArrayList;
import java.util.List;

public class SearchService {
	private Filter filter;
	public SearchService(Filter filter) {
		this.filter = filter;
	}
	public List<Product> search(SearchRequest search) {
		// Invoke some db or dao
		List<Product> products = new ArrayList<Product>(); // TODO get from DAO
		// apply filters on results
		List<Product> result = applyFilters(products, search);
		return result;
	}

	private List<Product> applyFilters(List<Product> products, SearchRequest search) {
		// NAIVE
//		for(Product product : products) {
//			boolean include = true;
//			if(search.filterInfo.priceMax.isPresent()) {
//				if(!(product.price <= search.filterInfo.priceMax.get())) {
//					include = false;
//				}
//			}
//			
//			
//			if(include) {
//				//results.add(product);
//			}
//		}
		
		
		// NAIVE
//		if(search.filterInfo.priceMin.isPresent() || search.filterInfo.priceMax.isPresent()) {
//			PriceFilter filter = new PriceFilter();
//			search.filterInfo.priceMax.ifPresent((max) -> filter.maxPrice = max);
//			search.filterInfo.priceMin.ifPresent((min) -> filter.minPrice = min);
//			
//			products = filter.filter(products);
//		}
//		if(search.filterInfo.ratingMin.isPresent() || search.filterInfo.ratingMax.isPresent()) {
//			RatingFilter filter = new RatingFilter();
//			search.filterInfo.ratingMax.ifPresent((max) -> filter.ratingMax = max);
//			search.filterInfo.ratingMin.ifPresent((min) -> filter.ratingMin = min);
//			
//			products = filter.filter(products);
//		}
		
		// Factory to makes a chain of filters based on what is inside of FilterInfo
		// Filter with the next filter inside it. Current filter does its stuff and then calls the next one.
		return filter.filter(products, search.filterInfo);
	}
}
