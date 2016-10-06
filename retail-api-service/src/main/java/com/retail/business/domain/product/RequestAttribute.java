package com.retail.business.domain.product;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author vinod dube
 *
 */
public class RequestAttribute {
	@JsonProperty
	private String name;
	@JsonProperty
	private String value;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(final String value) {
		this.value = value;
	}
}
