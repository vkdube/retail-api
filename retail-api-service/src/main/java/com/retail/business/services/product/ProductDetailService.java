package com.retail.business.services.product;

import java.util.Map;

import com.retail.api.entity.Price;
import com.retail.api.entity.Product;
import com.retail.business.services.request.ProductDetailRQ;
import com.retail.business.services.response.ProductDetailRS;

/*
 * @author vinod.g.dube
 */
public interface ProductDetailService {
	public ProductDetailRS retrieveProduct(ProductDetailRQ request);

	public Map<Long, Product> buildProductMap(final ProductDetailRQ productDetailRQ);

	public Product updateProduct(ProductDetailRQ request);

	public Price retrieveProductPrice(final Product product);

	public Product updateProductPrice(final Product product);

	public Product addProductAndPrice(ProductDetailRQ request);
}
