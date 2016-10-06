package com.retail.api.service.transformer.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.retail.api.data.util.RetailProductDataUtil;
import com.retail.api.entity.Product;
import com.retail.business.services.product.ProductDetailService;
import com.retail.business.services.product.impl.ProductDetailServiceImpl;
import com.retail.business.services.request.ProductDetailRQ;
import com.retail.business.services.response.ProductDetailRS;

/**
 * @author vinod dube
 *
 */
public class ProductTransformer {

	private ProductDetailService productDetailService = new ProductDetailServiceImpl();
	private static Map<Long, Product> productMap = new HashMap<Long, Product>();

	public ProductTransformer(final Product product) {
		if (!(product.getId() > 0)) {
			product.setId(RetailProductDataUtil.DEFAULT_PRODUCT_ID);
		}
		productMap = productDetailService.buildProductMap(buildRequest(product));
	}

	public Product getById(final long id) {
		final Product product = new Product();
		product.setId(id);
		productMap = productDetailService.buildProductMap(buildRequest(product));
		if (productMap.containsKey(id)) {
			return productMap.get(id);
		} else {
			return null;
		}
	}

	public Product modify(final Product product) {
		return productDetailService.updateProduct(buildRequest(product));
	}

	public Product add(final Product product) {
		return productDetailService.addProductAndPrice(buildRequest(product));
	}

	private ProductDetailRQ buildRequest(final Product product) {
		final ProductDetailRQ productDetailRQ = new ProductDetailRQ();
		productDetailRQ.setProduct(product);
		return productDetailRQ;
	}

	public List<Product> getAllProducts() {
		final ArrayList<Product> productList = new ArrayList<Product>();
		productMap = productDetailService.buildProductMap(new ProductDetailRQ());
		for (final Product product : productMap.values()) {
			productList.add(product);
		}
		return productList;
	}

	public ProductDetailRS getProductDetailService(final ProductDetailRQ offerDetailRQ) {
		final ProductDetailRS productDetailResponse = productDetailService.retrieveProduct(offerDetailRQ);
		return productDetailResponse;
	}

	public void setProductDetailService(final ProductDetailService productDetailService) {
		this.productDetailService = productDetailService;
	}

}
