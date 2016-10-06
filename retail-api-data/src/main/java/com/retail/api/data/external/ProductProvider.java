package com.retail.api.data.external;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.retail.api.entity.Product;

/**
 * @author vinod dube
 *
 */

public class ProductProvider {

	protected final Logger logger = LoggerFactory.getLogger(getClass());
	// private static String EXTERNAL_URL =
	// "https://api.target.com/products/v3/13860428?fields=descriptions&id_type=TCIN&key=43cJWpLjH8Z8oR18KdrZDBKAgLLQKJjz";
	private static final String BASE_URL = "https://api.target.com/products/v3/";
	private static final String EXTENDED_URL = "?fields=descriptions&id_type=TCIN&key=43cJWpLjH8Z8oR18KdrZDBKAgLLQKJjz";

	public String getProductUrl(final Product product) {
		final StringBuilder prodUrl = new StringBuilder();
		return prodUrl.append(BASE_URL).append(product.getId()).append(EXTENDED_URL).toString();
	}
}
