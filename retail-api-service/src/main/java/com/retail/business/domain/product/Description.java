package com.retail.business.domain.product;

/**
 * @author vinod dube
 *
 */
import org.codehaus.jackson.annotate.JsonProperty;

public class Description {
	@JsonProperty
	private String value;
	@JsonProperty
	private String type;

	public String getValue() {
		return value;
	}

	public void setValue(final String value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(final String type) {
		this.type = type;
	}
}
