package com.retail.business.domain.product;

/**
 * @author vinod dube
 *
 */
import org.codehaus.jackson.annotate.JsonProperty;

public class Feature {
	@JsonProperty
	private String feature;

	public String getFeature() {
		return feature;
	}

	public void setFeature(final String feature) {
		this.feature = feature;
	}
}
