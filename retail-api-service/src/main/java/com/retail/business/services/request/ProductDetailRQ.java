package com.retail.business.services.request;

import com.retail.api.entity.Product;
import com.retail.business.service.request.Request;

/**
 * @author vinod dube
 *
 */
public class ProductDetailRQ extends Request {
	private Product product;

	public Product getProduct() {
		return product;
	}

	public void setProduct(final Product product) {
		this.product = product;
	}

}
