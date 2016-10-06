package com.retail.business.services.product.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.retail.api.data.external.ProductProvider;
import com.retail.api.data.nosql.couchbase.CouchbasePriceProvider;
import com.retail.api.entity.Price;
import com.retail.api.entity.Product;
import com.retail.business.Business;
import com.retail.business.domain.product.Identifier;
import com.retail.business.domain.product.Item;
import com.retail.business.domain.product.RequestAttribute;
import com.retail.business.service.request.Request;
import com.retail.business.services.product.ProductDetailService;
import com.retail.business.services.request.ProductDetailRQ;
import com.retail.business.services.response.ProductCompositeResponse;
import com.retail.business.services.response.ProductDetailRS;

/*
 * @author vinod.g.dube
 */
@Component
@Transactional(rollbackFor = java.lang.Exception.class)
public class ProductDetailServiceImpl extends Business
		implements com.retail.business.service.Aggregator, ProductDetailService {
	private final CouchbasePriceProvider couchbasePriceProvider = new CouchbasePriceProvider();
	private final ProductProvider productProvider = new ProductProvider();
	private static final String PRODUCT_ID = "product_id";

	@Override
	public ProductDetailRS retrieveProduct(final ProductDetailRQ request) {
		if (null == request) {
			return new ProductDetailRS();
		} else {
			return getProductData(request);
		}
	}

	private ProductDetailRS getProductData(final ProductDetailRQ request) {
		final RestTemplate restTemplate = new RestTemplate();
		restTemplate.setMessageConverters(getMessageConverters());
		final HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		final HttpEntity<String> entity = new HttpEntity<String>(headers);

		try {
			if (null != request.getProduct()) {
				final ResponseEntity<ProductDetailRS> externalResponse = restTemplate.exchange(
						productProvider.getProductUrl(request.getProduct()), HttpMethod.GET, entity,
						ProductDetailRS.class);
				logger.info("Product information received from external url :"
						+ productProvider.getProductUrl(request.getProduct()));
				return externalResponse.getBody();
			}
		} catch (final RestClientException e) {
			logger.info("Product information couldn't find on the external url :" + e);
		}
		return null;
	}

	@Override
	public Product updateProduct(final ProductDetailRQ request) {
		// @ToDo: update Product info to EXTERNAL_URL, if interface details provided
		// to update the product info as per ProductDetailRQ on a backend service
		final Product product = updateProductPrice(request.getProduct());
		return product;
	}

	@Override
	public Price retrieveProductPrice(final Product product) {
		try {
			return couchbasePriceProvider.retrieveProductPrice(product);
		} catch (final Exception e) {
			logger.info("Error occured retrieving price for a Product:  " + product.getId(), e);
		}
		return null;
	}

	@Override
	public Product updateProductPrice(final Product product) {
		try {
			return couchbasePriceProvider.updateProductPrice(product);
		} catch (final Exception e) {
			logger.info("Error occured replacing or updating price for a Product:  " + product.getId(), e);
		}
		return null;
	}

	@Override
	public Product addProductAndPrice(final ProductDetailRQ request) {
		// @ToDo: add Product info to EXTERNAL_URL, if interface details provided
		// to add the product info as per ProductDetailRQ on a backend service
		try {
			return couchbasePriceProvider.addProductPrice(request.getProduct());
		} catch (final Exception e) {
			logger.info("Error occured creating price for a Product:  " + request.getProduct().getId(), e);
		}
		return null;
	}

	@Override
	public Map<Long, Product> buildProductMap(final ProductDetailRQ productDetailRQ) {
		final Map<Long, Product> productMap = new HashMap<Long, Product>();
		final Product product = new Product();
		// A request to store all product list
		final ProductDetailRS productRS = retrieveProduct(productDetailRQ);
		final ProductCompositeResponse compositeResponse = productRS.getProductCompositeResponse();
		if (productRS != null && null != compositeResponse && null != compositeResponse.getRequestAttributes()) {
			for (int i = 0; i < compositeResponse.getRequestAttributes().size(); i++) {
				final RequestAttribute requestAttribute = compositeResponse.getRequestAttributes().get(i);
				if (requestAttribute.getName().equals(PRODUCT_ID)) {
					// retrieve and set the product_id
					product.setId(NumberUtils.toLong(requestAttribute.getValue()));
					// retrive and set the online_description
					if (null != compositeResponse.getItems()) {
						for (int j = 0; j < compositeResponse.getItems().size(); j++) {
							final List<Item> productItems = compositeResponse.getItems();
							for (final Item productItem : productItems) {
								boolean isProductIdFoundOnItem = false;
								if (null != productItem.getIdentifier()) {
									for (final Identifier identifier : productItem.getIdentifier()) {
										if (requestAttribute.getValue().matches(identifier.getId())) {
											// product id match found, break and capture the
											// online_description info on this
											isProductIdFoundOnItem = true;
											break;
										}
									}
									if (isProductIdFoundOnItem) {
										// set the online description as a name from the product
										// Item
										if (null != productItem.getOnlineDescription()) {
											product.setName(productItem.getOnlineDescription().getValue());
										}
										break;
									}
								}
							}
						}
						product.setCurrentPrice(retrieveProductPrice(product));
						productMap.put(product.getId(), product);
						break;
					}
				}

			}
		}
		return productMap;
	}

	@Override
	public com.retail.business.service.response.Response processRequest(final Request request) {
		// TODO Auto-generated method stub -- to add common header info
		return null;
	}

	private static List<HttpMessageConverter<?>> getMessageConverters() {
		final List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
		converters.add(new MappingJacksonHttpMessageConverter());
		return converters;
	}

}
