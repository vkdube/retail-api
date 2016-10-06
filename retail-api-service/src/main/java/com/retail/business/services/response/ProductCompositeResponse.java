package com.retail.business.services.response;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

import com.retail.business.domain.product.Item;
import com.retail.business.domain.product.RequestAttribute;

/**
 * @author vinod dube
 *
 */
@JsonRootName("product_composite_response")
public class ProductCompositeResponse {
	@JsonProperty("request_attributes")
	private List<RequestAttribute> requestAttributes;
	@JsonProperty
	private List<Item> items;

	public List<RequestAttribute> getRequestAttributes() {
		return requestAttributes;
	}

	public void setRequestAttributes(final List<RequestAttribute> requestAttributes) {
		this.requestAttributes = requestAttributes;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(final List<Item> items) {
		this.items = items;
	}

}
