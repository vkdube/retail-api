package com.retail.business.domain.product;

/**
 * @author vinod dube
 *
 */
import org.codehaus.jackson.annotate.JsonProperty;

public class Identifier {
	@JsonProperty("id_type")
	private String idType;
	@JsonProperty
	private String id;
	@JsonProperty("is_primary")
	private String isPrimary;
	@JsonProperty
	private String source;

	public String getIdType() {
		return idType;
	}

	public void setIdType(final String idType) {
		this.idType = idType;
	}

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getIsPrimary() {
		return isPrimary;
	}

	public void setIsPrimary(final String isPrimary) {
		this.isPrimary = isPrimary;
	}

	public String getSource() {
		return source;
	}

	public void setSource(final String source) {
		this.source = source;
	}

}
