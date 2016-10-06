package com.retail.business.services.response;

import org.codehaus.jackson.annotate.JsonProperty;

import com.retail.business.service.response.Response;

/**
 * @author vinod dube
 *
 */
public class ProductDetailRS extends Response {
	@JsonProperty("product_composite_response")
	private ProductCompositeResponse productCompositeResponse;

	public ProductCompositeResponse getProductCompositeResponse() {
		return productCompositeResponse;
	}

	public void setProductCompositeResponse(final ProductCompositeResponse productCompositeResponse) {
		this.productCompositeResponse = productCompositeResponse;
	}

}
