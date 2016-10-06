package com.retail.business.domain.product;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author vinod dube
 *
 */
public class AlternateDescription {
	@JsonProperty
	private String type;
	@JsonProperty
	private String value;
	@JsonProperty("type_description")
	private String typeDescription;

	public String getType() {
		return type;
	}

	public void setType(final String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(final String value) {
		this.value = value;
	}

	public String getTypeDescription() {
		return typeDescription;
	}

	public void setTypeDescription(final String typeDescription) {
		this.typeDescription = typeDescription;
	}

}
